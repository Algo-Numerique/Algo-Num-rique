import java.text.DecimalFormat;

public class ResolutionCholeskyBanded {
    private double[][] matrice;
    private double[] resultat;
    private int n;
    private int bandwidth;

    public ResolutionCholeskyBanded(double[][] matrice, int bandwidth) {
        this.matrice = matrice;
        this.n = matrice.length;
        this.resultat = new double[matrice[0].length]; // Assuming the last column is the B vector
        this.bandwidth = bandwidth;
        afficheSolution();
    }

    public void resoudre_CholeskyBanded() {
        double[][] L = decomposerCholesky(matrice, bandwidth);
        resoudre_LyEqualsB(L);
        resoudre_UxEqualsY(transposer(L));
    }

    private double[][] decomposerCholesky(double[][] matrice, int bandwidth) {
        double[][] L = new double[n][bandwidth];

        for (int j = 0; j < n; j++) {
            int start = Math.max(0, j - bandwidth + 1);
            double ljj = matrice[j][j];

            for (int k = start; k < j; k++) {
                double ljk = L[j][k - start];
                ljj -= ljk * ljk;
            }

            ljj = Math.sqrt(ljj);
            L[j][0] = ljj;

            for (int i = j + 1; i < Math.min(n, j + bandwidth); i++) {
                double lij = matrice[i][j];

                for (int k = start; k < j; k++) {
                    double ljk = L[i][k - start];
                    lij -= ljk * L[j][k - start];
                }

                L[i][j - start] = lij / ljj;
            }
        }

        return L;
    }

    private void resoudre_LyEqualsB(double[][] L) {
        for (int i = 0; i < n; i++) {
            double sum = 0.0;
            int start = Math.max(0, i - bandwidth + 1);
            for (int j = start; j < i; j++) {
                sum += L[i][j - start] * resultat[j];
            }
            resultat[i] = (matrice[i][n] - sum) / L[i][0]; // Assuming matrice[i][n] is the B vector
        }
    }

    private void resoudre_UxEqualsY(double[][] U) {
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            int start = Math.max(0, i - bandwidth + 1);
            for (int j = i + 1; j < Math.min(n, i + bandwidth); j++) {
                sum += U[i][j - start] * resultat[j - start];
            }
            resultat[i] = (resultat[i] - sum) / U[i][0];
        }
    }


    private double[][] transposer(double[][] matrice) {
        int numRows = matrice.length;
        int numCols = Math.min(bandwidth, matrice[0].length);

        double[][] transposee = new double[numCols][numRows];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                transposee[j][i] = matrice[i][j];
            }
        }

        return transposee;
    }

    public String afficheSolution() {
        StringBuilder str = new StringBuilder();
        DecimalFormat format = new DecimalFormat("#.##");
        for (double value : resultat) {
            str.append(format.format(value)).append("\n");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        // Example usage with a banded matrix
        int bandwidth = 2; // Set the bandwidth of the banded matrix
        double[][] matriceBanded = {{4, 1, 0, 0, 7}, {1, 5, 3, 0, 5}, {0, 3, 5, 8, 0}};
        ResolutionCholeskyBanded choleskyBanded = new ResolutionCholeskyBanded(matriceBanded, bandwidth);
        choleskyBanded.resoudre_CholeskyBanded();
        System.out.println("Solution for the banded matrix:");
        System.out.println(choleskyBanded.afficheSolution());
    }
}

