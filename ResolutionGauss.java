import java.text.DecimalFormat;

public class ResolutionGauss {
    private double[] resultat;
    private MatrixClass matrix;
    private Vector vector;
    private int n;
    private String type;
    public ResolutionGauss(MatrixClass mat,Vector vect){
        matrix= mat;
        vector=vect;
        n=matrix.getSize();
        type= matrix.getType();
        resultat= new double[n];
        resolution();
    }
    
    public void resoudre_MatrixDense(){
        double[][] matrice=concatenerMatriceEtVecteur();
        triangularisation(matrice);
        resoudre_MatrixTriangSup1(matrice);
       
    }
    public void resoudre_MatrixTrianSup(){
        double[][] matrice=concatenerMatriceEtVecteur();
        resoudre_MatrixTriangSup1(matrice);
    }
    public void resoudre_MatrixTriangInf(){
        double[][] matrice=concatenerMatriceEtVecteur();
        resoudre_MatrixTriangInf1(matrice);
    }
    public void resoudre_MatrixTriangSup1(double[][] matrice) {
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += matrice[i][j] * resultat[j];
            }
            resultat[i] = (matrice[i][n] - sum) / matrice[i][i];
        }
    }
    
    public void resoudre_MatrixTriangInf1(double[][] matrice) {
        for (int i = 0; i < n; i++) {
            double sum = 0.0;
            for (int j = 0; j < i; j++) {
                sum += matrice[i][j] * resultat[j];
            }
            resultat[i] = (matrice[i][n] - sum) / matrice[i][i];
        }
    }
    public double[][] concatenerMatriceEtVecteur() {
        // Créer une nouvelle matrice avec une colonne supplémentaire pour le vecteur
        double[][] matriceEtVecteur = new double[n][n + 1];

        // Copier la matrice d'origine dans la nouvelle matrice
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriceEtVecteur[i][j] = matrix.matrix[i][j];
            }
        }

        // Copier le vecteur dans la dernière colonne de la nouvelle matrice
        for (int i = 0; i < n; i++) {
            matriceEtVecteur[i][n] = vector.vector[i];
        }
        return matriceEtVecteur;
    }
    public void triangularisation(double[][] matrice) {
        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {
                matrice[k][i] = matrice[k][i] / matrice[i][i];
                for (int j = i + 1; j <= n; j++) {
                    matrice[k][j] -= matrice[k][i] * matrice[i][j];
                }
            }
        }
    }
    public void resolution(){
        switch (type) {
            case "triangsup":
                resoudre_MatrixTrianSup();
                break;
            case "trianginf":
                resoudre_MatrixTriangInf();
                break;
            case "dense":
                resoudre_MatrixDense();
                break;
            default:
                break;
        }
    }
    public String afficheVector(){
        String str="";
        DecimalFormat format = new DecimalFormat("#.##");
        for (int i = 0; i < n; i++) {
                String chaine = format.format(resultat[i]);
                str+=chaine+"\n";
        }
        return str;
    }

}
