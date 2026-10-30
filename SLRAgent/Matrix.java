/*Equipo:
    Villalobos Alvarado Alma Belen.
    Saucedo Ortiz Cesar Jesus.
    Beltran Arellano Alison Odalis.
*/  
public final class Matrix {
    private Matrix() {}

    public static double[][] transpose(double[][] a) {
        double[][] t = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++) t[j][i] = a[i][j];
        return t;
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < b.length; k++) c[i][j] += a[i][k] * b[k][j];
        return c;
    }

    public static double[] multiply(double[][] a, double[] v) {
        double[] r = new double[a.length];
        for (int i = 0; i < a.length; i++)
            for (int k = 0; k < v.length; k++) r[i] += a[i][k] * v[k];
        return r;
    }

    public static double[][] inverse(double[][] m) {
        int n = m.length;
        double[][] a = new double[n][2 * n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(m[i], 0, a[i], 0, n);
            a[i][n + i] = 1.0;
        }
        for (int col = 0; col < n; col++) {
            int piv = col;
            for (int r = col + 1; r < n; r++)
                if (Math.abs(a[r][col]) > Math.abs(a[piv][col])) piv = r;
            if (Math.abs(a[piv][col]) < 1e-12)
                throw new ArithmeticException("Matriz singular: no existe (X^T X)^-1");
            double[] tmp = a[col]; a[col] = a[piv]; a[piv] = tmp;
            double p = a[col][col];
            for (int j = 0; j < 2 * n; j++) a[col][j] /= p;
            for (int r = 0; r < n; r++) {
                if (r == col) continue;
                double f = a[r][col];
                for (int j = 0; j < 2 * n; j++) a[r][j] -= f * a[col][j];
            }
        }
        double[][] inv = new double[n][n];
        for (int i = 0; i < n; i++) System.arraycopy(a[i], n, inv[i], 0, n);
        return inv;
    }
}
