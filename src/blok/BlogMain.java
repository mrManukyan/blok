package blok;

import blok.exception.InputMismatchException;
import blok.model.Post;
import blok.model.User;
import blok.storage.impl.PostStorageImpl;
import blok.storage.impl.UserStorageImpl;

import java.util.Date;
import java.util.Scanner;

public class BlogMain implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static PostStorageImpl storage = new PostStorageImpl();
    private static UserStorageImpl userStorage = new UserStorageImpl();

    public static void main(String[] args) throws InputMismatchException {
       boolean isInitial = true;
       while (isInitial) {

           printInitialComand();

           int initialComand = Integer.parseInt(scanner.nextLine());
           switch (initialComand) {
               case REGISTER:
                   LoginRegistr();
                   break;
               case LOGIN:
                   isInitial= Logout();
                   break;
               default:
                   printInitialComand();
           }
       }
        isInitial = true;
        boolean isRun = true;
        while (isRun) {
            printComands();
            int comands;
            try {
                comands = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please imput number!");
                comands = -1;
            }
            switch (comands) {
                case EXIT:
                    isRun = false;
                    System.out.println("Goodbye");
                    break;
                case ADD_POST:
                    addpost();
                    break;
                case SEARCH_POST:
                    searchPost();
                    break;
                case POSTS_BY_CATEGORY:
                    postsByCategory();
                    break;
                case ALL_POSTS:
                    storage.printAllPost();
                    break;
                default:
                    System.out.println("Wrong commands!");
            }
        }
    }

    private static Boolean Logout() throws InputMismatchException {
        System.out.println("Plais enter maile pasword");
       return userStorage.searchPostsByKeyword(scanner.nextLine(),scanner.nextLine());

    }

    private static void LoginRegistr() {
        System.out.println("Plaese entr Name, Surname, email, Passwort");
        String userStr = scanner.nextLine();
        String[] userMasStr = userStr.split(",");
        User user = new User();
        user.setName(userMasStr[0]);
        user.setSurname(userMasStr[1]);
        user.setEmail(userMasStr[2]);
        user.setPassword(userMasStr[3]);
        userStorage.addUser(user);
        System.out.println(" tanck you ");

    }

    private static void postsByCategory() {
        System.out.println("Please category For Print blok.model.Post Categori  ");
        storage.printPostByCategory(scanner.nextLine());
    }

    public static void searchPost() {
        System.out.println("Please write post title or text for search post");
        storage.searchPostsByKeyword(scanner.nextLine());
    }


    private static void addpost() {
        System.out.println("Pliase Add blok.model.Post (Title, Text, Category)");
        try {
            String postStr = scanner.nextLine();
            String[] postMasStr = postStr.split(",");
            Post post = new Post();
            post.setTitle(postMasStr[0]);
            post.setText(postMasStr[1]);
            post.setCategory(postMasStr[2]);
            post.setDate(new Date());
            storage.add(post);

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Incorrect value! Please try again");
            addpost();
        }
    }

    private static void printInitialComand() {
        System.out.println("Please imput " + REGISTER + " For Register");
        System.out.println("Please imput " + LOGIN + " For Login");
    }

    private static void printComands() {
        System.out.println("Please imput " + EXIT + " FOR EXIT");
        System.out.println("Please imput " + ADD_POST + " FOR ADD POST");
        System.out.println("Please imout " + SEARCH_POST + " FOR SEARCH POST");
        System.out.println("Pliase imput " + POSTS_BY_CATEGORY + " FOR POSTS BY CATEGORY");
        System.out.println("Pliase imput " + ALL_POSTS + " FOR ALL POSTS");
    }
}
