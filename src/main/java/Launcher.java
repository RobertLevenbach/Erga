public class Launcher {

    Launcher launcher;


    public static void main(String[] args){
        new Launcher().launch();
    }

    private void launch() {
        int age =2;
        switchStatement(age);

    }

    public String switchStatement(int age){
        switch (age){
            case 1:
                System.out.println("you can crawl");
                return "you can crawl";
            case 2:
                System.out.println("you can say hi");
                return "you can say hi";
        }
        return "you have no age";
    }
}
