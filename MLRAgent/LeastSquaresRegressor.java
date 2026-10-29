/** Least Squares Regressor: beta = (X^T X)^-1 X^T y. Base de SLR, PR y MLR. */
public abstract class LeastSquaresRegressor {
    protected double[][] design;   // matriz de diseño X (primera columna de 1s)
    protected double[] y;          // vector de respuesta
    protected double[] betas;      // [b0, b1, ..., bk]

    protected void fit(double[][] design, double[] y) {
        this.design = design;
        this.y = y;
        double[][] xt = Matrix.transpose(design);
        double[][] inv = Matrix.inverse(Matrix.multiply(xt, design));
        this.betas = Matrix.multiply(inv, Matrix.multiply(xt, y));
    }

    public double[] getBetas() { return betas; }

    public double getBeta(int i) { return betas[i]; }

    /** y_hat = X_row . beta  (X_row ya incluye el 1 inicial). */
    protected double predictRow(double[] row) {
        double s = 0;
        for (int i = 0; i < betas.length; i++) s += betas[i] * row[i];
        return s;
    }

    /** R^2 = 1 - SSE/SST */
    public double calculateRSquared() {
        double mean = 0;
        for (double v : y) mean += v;
        mean /= y.length;
        double sse = 0, sst = 0;
        for (int i = 0; i < y.length; i++) {
            double e = y[i] - predictRow(design[i]);
            sse += e * e;
            sst += (y[i] - mean) * (y[i] - mean);
        }
        return 1.0 - sse / sst;
    }

    public abstract String getEquation();
}
