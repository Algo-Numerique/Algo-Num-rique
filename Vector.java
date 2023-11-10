import java.util.Random;

public class Vector {
    private int size;
    int[] vector;
    public Vector(int size){
        this.size=size;
        this.vector=new int[size];
        createVector();
    }
    public void createVector(){
         Random random = new Random();
        // Remplissage de la matrice triangulaire supérieure avec des entiers aléatoires
        for (int i = 0; i < size; i++) {
                vector[i] = random.nextInt(10); // Génère un entier aléatoire entre 0 et 99
        }
    }
    public String afficheVector(){
        String str="";
        for (int i = 0; i < size; i++) {
               str+=vector[i]+"\n";
        }
        return str;
    }

}
