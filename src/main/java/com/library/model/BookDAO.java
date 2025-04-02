    package com.library.model;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
    
    import com.library.config.ConnectionDB;
    
    public class BookDAO {
        private Connection connection;
    
        public void beginTransaction() throws SQLException {
            if (connection == null) {
                connection = ConnectionDB.initConnection();
            }
            connection.setAutoCommit(false);
        }
    
        public void commit() throws SQLException {
            if (connection != null) {
                try {
                    connection.commit();
                } catch (SQLException e) {
                    connection.rollback();
                    throw e;
                } finally {
                    connection.close();
                    connection = null;
                }
            }
        }
    
        public void rollback() throws SQLException {
            if (connection != null) {
                try {
                    connection.rollback();
                } finally {
                    connection.close();
                    connection = null;
                }
            }
        }
    
        public boolean createBook(Book book) throws SQLException {
            if (connection == null) {
                throw new IllegalStateException("La connexió no està activa");
            }
            String sql = "INSERT INTO books (title, description, isbn, author, genre, isAvailable) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
                pstmn.setString(1, book.getTitle());
                pstmn.setString(2, book.getDescription());
                pstmn.setString(3, book.getIsbn());
                pstmn.setString(4, book.getAuthor());
                pstmn.setString(5, book.getGenre());
                pstmn.setBoolean(6, true);
                int result = pstmn.executeUpdate();
                return result > 0;
            }
        }
    
        public List<Book> getAllBooks() throws SQLException {
            if (connection == null) {
                beginTransaction(); 
            }
            String sql = "SELECT * FROM books";
            List<Book> books = new ArrayList<>();
            try (PreparedStatement pstmn = connection.prepareStatement(sql); ResultSet rs = pstmn.executeQuery()) {
                while (rs.next()) {
                    books.add(mapResultSetToBook(rs));
                }
            }
            return books;
        }
    
        public Book getBookById(int id) throws SQLException {
            if (connection == null) {
                beginTransaction(); 
            }
            String sql = "SELECT * FROM books WHERE id = ?";
            try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
                pstmn.setInt(1, id);
                try (ResultSet rs = pstmn.executeQuery()) {
                    if (rs.next()) {
                        return mapResultSetToBook(rs);
                    }
                }
            }
            return null;
        }
    
        public List<Book> getBooksByField(String field, String value) throws SQLException {
            if (connection == null) {
                beginTransaction(); 
            }
    
            String columnName;
            columnName = switch (field) {
                case "title" -> "title";
                case "author" -> "author";
                case "genre" -> "genre";
                default -> throw new IllegalArgumentException("Camp no permès a la cerca");
            };
    
            String sql = "SELECT * FROM books WHERE " + columnName + " ILIKE ?";
    
            List<Book> books = new ArrayList<>();
            try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
                pstmn.setString(1, "%" + value + "%");
                try (ResultSet rs = pstmn.executeQuery()) {
                    while (rs.next()) {
                        books.add(mapResultSetToBook(rs));
                    }
                }
            }
            return books;
        }
    
        public List<Book> getBooksByTitle(String title) throws SQLException {
            return getBooksByField("title", title);
        }
    
        public List<Book> getBooksByAuthor(String author) throws SQLException {
            return getBooksByField("author", author);
        }
    
        public List<Book> getBooksByGenre(String genre) throws SQLException {
            return getBooksByField("genre", genre);
        }
    
        public List<Book> getAvailableBooks() throws SQLException {
            if (connection == null) {
                beginTransaction(); 
            }
            String sql = "SELECT * FROM books WHERE isAvailable = TRUE";
            List<Book> books = new ArrayList<>();
            try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
                try (ResultSet rs = pstmn.executeQuery()) {
                    while (rs.next()) {
                        books.add(mapResultSetToBook(rs));
                    }
                }
            }
            return books;
        }
    
        public boolean updateBook(Book book) throws SQLException {
            if (connection == null) {
                beginTransaction();
            }
            String sql = "UPDATE books SET title = ?, description = ?, isbn = ?, author = ?, genre = ?, isAvailable = ? WHERE id = ?";
            try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
                pstmn.setString(1, book.getTitle());
                pstmn.setString(2, book.getDescription());
                pstmn.setString(3, book.getIsbn());
                pstmn.setString(4, book.getAuthor());
                pstmn.setString(5, book.getGenre());
                pstmn.setBoolean(6, book.getIsAvailable());
                pstmn.setInt(7, book.getId());
                int result = pstmn.executeUpdate();
                return result > 0;
            }
        }
    
        public boolean deleteBook(int id) throws SQLException {
            if (connection == null) {
                beginTransaction(); 
            }
            String sql = "DELETE FROM books WHERE id = ?";
            try (PreparedStatement pstmn = connection.prepareStatement(sql)) {
                pstmn.setInt(1, id);
                int result = pstmn.executeUpdate();
                return result > 0;
            }
        }
    
        private Book mapResultSetToBook(ResultSet rs) throws SQLException {
            return new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("isbn"),
                    rs.getString("author"),
                    rs.getString("genre"),
                    rs.getBoolean("isAvailable"));
        }
    }