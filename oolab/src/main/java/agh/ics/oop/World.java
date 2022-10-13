package agh.ics.oop;

public class World {
    public static void run(Kierunki[] kierunki){
        for (Kierunki kierunek : kierunki){
            switch (kierunek) {
                case forward -> System.out.println("Zwierzak idzie do przodu");
                case backward -> System.out.println("Zwierzak idzie do tyłu");
                case right -> System.out.println("Zwierzak skręca w prawo");
                case left -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }


    public static void strToEnum(String[] args, Kierunki[] kierunki, int l){
        for (int i = 0; i < l; i++){
            switch (args[i]) {
                case "f" -> kierunki[i] = Kierunki.forward;
                case "b" -> kierunki[i] = Kierunki.backward;
                case "r" -> kierunki[i] = Kierunki.right;
                case "l" -> kierunki[i] = Kierunki.left;
            }
        }
    }


    public static void main(String[] args){
        System.out.println("start");
        int l = args.length;
        Kierunki[] kierunki = new Kierunki[l];
        strToEnum(args, kierunki, l);
        run(kierunki);
        System.out.println("stop");
    }
}
