package view;


import java.util.*;

import controller.*;
import exception.EntityNotFoundException;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.metamodel.Metamodel;
import service.AdminService;
import entity.*;
import repository.Repository;
import service.AuthenticationService;
import service.CriticService;
import enums.AuthorityEnum;

public class ViewMain {
    public static void main(String[] args) throws EntityNotFoundException {
        AuthorityEnum authorityEnum = null;
        EntityManager entityManager = new EntityManager() {
            @Override
            public void persist(Object o) {

            }

            @Override
            public <T> T merge(T t) {
                return null;
            }

            @Override
            public void remove(Object o) {

            }

            @Override
            public <T> T find(Class<T> aClass, Object o) {
                return null;
            }

            @Override
            public <T> T find(Class<T> aClass, Object o, Map<String, Object> map) {
                return null;
            }

            @Override
            public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType) {
                return null;
            }

            @Override
            public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType, Map<String, Object> map) {
                return null;
            }

            @Override
            public <T> T getReference(Class<T> aClass, Object o) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public void setFlushMode(FlushModeType flushModeType) {

            }

            @Override
            public FlushModeType getFlushMode() {
                return null;
            }

            @Override
            public void lock(Object o, LockModeType lockModeType) {

            }

            @Override
            public void lock(Object o, LockModeType lockModeType, Map<String, Object> map) {

            }

            @Override
            public void refresh(Object o) {

            }

            @Override
            public void refresh(Object o, Map<String, Object> map) {

            }

            @Override
            public void refresh(Object o, LockModeType lockModeType) {

            }

            @Override
            public void refresh(Object o, LockModeType lockModeType, Map<String, Object> map) {

            }

            @Override
            public void clear() {

            }

            @Override
            public void detach(Object o) {

            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public LockModeType getLockMode(Object o) {
                return null;
            }

            @Override
            public void setProperty(String s, Object o) {

            }

            @Override
            public Map<String, Object> getProperties() {
                return null;
            }

            @Override
            public Query createQuery(String s) {
                return null;
            }

            @Override
            public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
                return null;
            }

            @Override
            public Query createQuery(CriteriaUpdate criteriaUpdate) {
                return null;
            }

            @Override
            public Query createQuery(CriteriaDelete criteriaDelete) {
                return null;
            }

            @Override
            public <T> TypedQuery<T> createQuery(String s, Class<T> aClass) {
                return null;
            }

            @Override
            public Query createNamedQuery(String s) {
                return null;
            }

            @Override
            public <T> TypedQuery<T> createNamedQuery(String s, Class<T> aClass) {
                return null;
            }

            @Override
            public Query createNativeQuery(String s) {
                return null;
            }

            @Override
            public Query createNativeQuery(String s, Class aClass) {
                return null;
            }

            @Override
            public Query createNativeQuery(String s, String s1) {
                return null;
            }

            @Override
            public StoredProcedureQuery createNamedStoredProcedureQuery(String s) {
                return null;
            }

            @Override
            public StoredProcedureQuery createStoredProcedureQuery(String s) {
                return null;
            }

            @Override
            public StoredProcedureQuery createStoredProcedureQuery(String s, Class... classes) {
                return null;
            }

            @Override
            public StoredProcedureQuery createStoredProcedureQuery(String s, String... strings) {
                return null;
            }

            @Override
            public void joinTransaction() {

            }

            @Override
            public boolean isJoinedToTransaction() {
                return false;
            }

            @Override
            public <T> T unwrap(Class<T> aClass) {
                return null;
            }

            @Override
            public Object getDelegate() {
                return null;
            }

            @Override
            public void close() {

            }

            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public EntityTransaction getTransaction() {
                return null;
            }

            @Override
            public EntityManagerFactory getEntityManagerFactory() {
                return null;
            }

            @Override
            public CriteriaBuilder getCriteriaBuilder() {
                return null;
            }

            @Override
            public Metamodel getMetamodel() {
                return null;
            }

            @Override
            public <T> EntityGraph<T> createEntityGraph(Class<T> aClass) {
                return null;
            }

            @Override
            public EntityGraph<?> createEntityGraph(String s) {
                return null;
            }

            @Override
            public EntityGraph<?> getEntityGraph(String s) {
                return null;
            }

            @Override
            public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> aClass) {
                return null;
            }
        };
        String className = new String();
        Repository<Book> bookRepository = new Repository<>(entityManager, className);
        Repository<Author> authorRepository = new Repository<>(entityManager, className);
        Repository<Review> reviewRepository = new Repository<>(entityManager, className);
        Repository<User> userRepository = new Repository<>(entityManager, className);
        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        AdminService adminService = new AdminService(authenticationService, authorRepository);
        CriticService criticService = new CriticService(bookRepository, reviewRepository, userRepository);
        UserController userController = new UserController(authenticationService);
        CriticController criticController = new CriticController(criticService);
        ;
        BookView bookView = new BookView();
        BookController bookController = new BookController(bookRepository, bookView);
        AdminController adminController = new AdminController(adminService);
        Scanner input = new Scanner(System.in);
        String adminPass = new String();
        String adminUser = new String();
        String UserN = new String();
        String UserP = new String();


        String username = input.nextLine();
        System.out.println("Username:" + username);
        String password = input.nextLine();
        System.out.println("Password:" + password);
        userController.logIn(adminUser, adminPass);
        {
            Scanner adminMenu = new Scanner(System.in);
            System.out.println("1. Add Author");
            System.out.println("2. Add Book for Author");
            System.out.println("3. Quit");
            Integer select = adminMenu.nextInt();
            do {
                switch (select) {
                    case 1:

                        Author a;
                        System.out.println("Author name:");
                        String name = adminMenu.nextLine();
                        System.out.println("Author education");
                        String educ = adminMenu.nextLine();
                        System.out.println("Author birthYear");
                        Integer birthYear = adminMenu.nextInt();
                        List<Book> bookList = new List<Book>() {
                            @Override
                            public int size() {
                                return 0;
                            }

                            @Override
                            public boolean isEmpty() {
                                return false;
                            }

                            @Override
                            public boolean contains(Object o) {
                                return false;
                            }

                            @Override
                            public Iterator<Book> iterator() {
                                return null;
                            }

                            @Override
                            public Object[] toArray() {
                                return new Object[0];
                            }

                            @Override
                            public <T> T[] toArray(T[] a) {
                                return null;
                            }

                            @Override
                            public boolean add(Book book) {
                                return false;
                            }

                            @Override
                            public boolean remove(Object o) {
                                return false;
                            }

                            @Override
                            public boolean containsAll(Collection<?> c) {
                                return false;
                            }

                            @Override
                            public boolean addAll(Collection<? extends Book> c) {
                                return false;
                            }

                            @Override
                            public boolean addAll(int index, Collection<? extends Book> c) {
                                return false;
                            }

                            @Override
                            public boolean removeAll(Collection<?> c) {
                                return false;
                            }

                            @Override
                            public boolean retainAll(Collection<?> c) {
                                return false;
                            }

                            @Override
                            public void clear() {

                            }

                            @Override
                            public Book get(int index) {
                                return null;
                            }

                            @Override
                            public Book set(int index, Book element) {
                                return null;
                            }

                            @Override
                            public void add(int index, Book element) {

                            }

                            @Override
                            public Book remove(int index) {
                                return null;
                            }

                            @Override
                            public int indexOf(Object o) {
                                return 0;
                            }

                            @Override
                            public int lastIndexOf(Object o) {
                                return 0;
                            }

                            @Override
                            public ListIterator<Book> listIterator() {
                                return null;
                            }

                            @Override
                            public ListIterator<Book> listIterator(int index) {
                                return null;
                            }

                            @Override
                            public List<Book> subList(int fromIndex, int toIndex) {
                                return null;
                            }
                        };
                        //System.out.println("Author Books");
                        //String bookName = adminMenu.nextLine();
                        //System.out.println("Book description");
                        //String descript = adminMenu.nextLine();
                        //System.out.println("Book type");
                        //String type = adminMenu.nextLine();
                        //System.out.println("Publication year");
                        //Integer pubY = adminMenu.nextInt();
                        //System.out.println("Where can you find the book?");
                        //List<BookStore> bookStoreList = new List<BookStore>() {
                        a = new Author(name, educ, bookList, birthYear);
                        adminController.addAuthor(a);
                        break;
                    case 2:

                        Book b;
                        Author au;
                        Editor e;

                        System.out.println("Enter AuthorID");
                        Integer authorId = adminMenu.nextInt();
                        System.out.println("Book name");
                        String bookName = adminMenu.nextLine();
                        System.out.println("Description");
                        String descr = adminMenu.nextLine();
                        System.out.println("Book Type");
                        String type = adminMenu.nextLine();
                        System.out.println("Publication Year?");
                        Integer pubyear = adminMenu.nextInt();
                        au = new Author();
                        e = new Editor();
                        List<BookStore> bookStoreList = new List<BookStore>() {
                            @Override
                            public int size() {
                                return 0;
                            }

                            @Override
                            public boolean isEmpty() {
                                return false;
                            }

                            @Override
                            public boolean contains(Object o) {
                                return false;
                            }

                            @Override
                            public Iterator<BookStore> iterator() {
                                return null;
                            }

                            @Override
                            public Object[] toArray() {
                                return new Object[0];
                            }

                            @Override
                            public <T> T[] toArray(T[] a) {
                                return null;
                            }

                            @Override
                            public boolean add(BookStore bookStore) {
                                return false;
                            }

                            @Override
                            public boolean remove(Object o) {
                                return false;
                            }

                            @Override
                            public boolean containsAll(Collection<?> c) {
                                return false;
                            }

                            @Override
                            public boolean addAll(Collection<? extends BookStore> c) {
                                return false;
                            }

                            @Override
                            public boolean addAll(int index, Collection<? extends BookStore> c) {
                                return false;
                            }

                            @Override
                            public boolean removeAll(Collection<?> c) {
                                return false;
                            }

                            @Override
                            public boolean retainAll(Collection<?> c) {
                                return false;
                            }

                            @Override
                            public void clear() {

                            }

                            @Override
                            public BookStore get(int index) {
                                return null;
                            }

                            @Override
                            public BookStore set(int index, BookStore element) {
                                return null;
                            }

                            @Override
                            public void add(int index, BookStore element) {

                            }

                            @Override
                            public BookStore remove(int index) {
                                return null;
                            }

                            @Override
                            public int indexOf(Object o) {
                                return 0;
                            }

                            @Override
                            public int lastIndexOf(Object o) {
                                return 0;
                            }

                            @Override
                            public ListIterator<BookStore> listIterator() {
                                return null;
                            }

                            @Override
                            public ListIterator<BookStore> listIterator(int index) {
                                return null;
                            }

                            @Override
                            public List<BookStore> subList(int fromIndex, int toIndex) {
                                return null;
                            }
                        };
                        b = new Book(authorId, bookName, descr, type, bookStoreList, au, pubyear, e);
                        adminController.addBookForAuth(authorId, b);
                }


            } while (select != 3);
            adminMenu.close();
        }

        userController.logIn(UserN, UserP);
        {
            Scanner userMenu = new Scanner(System.in);
            int selection = userMenu.nextInt();
            System.out.println("1:Display Books");
            System.out.println("2: Add Review");
            System.out.println("3: Quit");
            do {
                switch (selection) {
                    case 1:
                        bookController.displayAll();
                        break;
                    case 2:
                        User critic = new User();
                        System.out.println("Book id");
                        Integer bookId = userMenu.nextInt();
                        System.out.println("Text");
                        String text = userMenu.nextLine();
                        criticController.addReview(critic, bookId, text);
                }


            } while (selection != 3);

        }


    }
}