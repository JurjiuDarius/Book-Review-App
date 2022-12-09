package view;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

public class ViewMain {
    public static void main(String[] args) throws EntityNotFoundException {
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
        Repository<Book> bookRepository = new Repository<>(entityManager,className);
        Repository<Author> authorRepository = new Repository<>(entityManager,className);
        Repository<Review> reviewRepository = new Repository<>(entityManager,className);
        Repository<User> userRepository = new Repository<>(entityManager,className);
        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        AdminService adminService = new AdminService(authenticationService,authorRepository);
        CriticService criticService = new CriticService(bookRepository,reviewRepository,userRepository);
        UserController userController = new UserController(authenticationService);
        CriticController criticController = new CriticController(criticService);;
        AdminController adminController = new AdminController(adminService);
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        System.out.println("Username:"+username);
        String password = input.nextLine();
        System.out.println("Password:" + password);
        userController.logIn(username,password);
        int selection;
        Scanner adminMenu = new Scanner(System.in);
        System.out.println("1. Add Author");
        System.out.println("2. Add Books for Author");
        System.out.println("3. Quit");
        do{
            selection = adminMenu.nextInt();
            if(selection == 1){
               System.out.println("Enter Author Name");
               Scanner myObj = new Scanner(System.in);
               String userInput = myObj.nextLine();
               System.out.println("Enter Authorr Education");
               String education = myObj.nextLine();
               System.out.println("Enter Author Birthday");
               Integer birthday = Integer.valueOf(myObj.nextLine());
               Author a;
               a = new Author(userInput,education,bookArrayList,birthday);
               adminController.addAuthor(a);

            }
            else if (selection == 2){
                Scanner myObj2 = new Scanner(System.in);
                System.out.println("To which author do you wanna add books");
                Integer authorId = myObj2.nextInt();
                System.out.println("Enter Book name");
                String name = myObj2.nextLine();
                System.out.println("Enter Publication Year");
                Integer pubY = myObj2.nextInt();
                Book book = new Book();
                adminController.addBookForAuth(authorId,book);
            }
            else if (selection == 3);
            System.out.println("3");
        }while(selection != 4);
        adminMenu.close();


    }
    }