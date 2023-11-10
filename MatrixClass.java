import java.util.Random;

public class MatrixClass {
    private String type;
    private int size;
    int[][] matrix;
    public MatrixClass(String type,int size){
        this.type=type;
        this.size=size;
        this.matrix = new int[size][size]; 
        createMatrix();
    }
    public void createMatrixTriangSup(){
        Random random = new Random();

        // Remplissage de la matrice triangulaire supérieure avec des entiers aléatoires
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                matrix[i][j] = random.nextInt(10); // Génère un entier aléatoire entre 0 et 99
            }
        }
        
    }
    public void createMatrixTriangInf(){
        Random random = new Random();

        // Remplissage de la matrice triangulaire supérieure avec des entiers aléatoires
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = random.nextInt(10); // Génère un entier aléatoire entre 0 et 99
            }
        }
    }
    public void createMatrixDense(){
        Random random = new Random();

        // Remplissage de la matrice triangulaire supérieure avec des entiers aléatoires
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(10); // Génère un entier aléatoire entre 0 et 99
            }
        }
    }
    public void createMatrixBande(){
        Random random = new Random();

        // Remplissage de la matrice triangulaire supérieure avec des entiers aléatoires
        for (int i = 0; i < size; i++) {
            for (int j = ((i-2) > 0) ? (i-2) : 0; j <( (size > (i+3)) ? (i+3) : size); j++) {
                matrix[i][j] = random.nextInt(10); // Génère un entier aléatoire entre 0 et 99
            }
        }
    }
    public void createMatrix(){
        switch (type) {
            case "triangsup":
                createMatrixTriangSup();
                break;
            case "trianginf":
                createMatrixTriangInf();
                break;
            case "dense":
                createMatrixDense();
                break;
            case "bande":
                createMatrixBande();
                break;
            default:
                break;
        }
    }
    public String getType(){
        return type;
    }
    public int getSize(){
        return size;
    }
    public String afficheMatrix(){
        String ch="";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ch+=matrix[i][j] + "\t";
            }
         ch+="\n";
        }
        return ch;
    }

}
