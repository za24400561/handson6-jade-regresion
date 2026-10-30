/*Equipo:
    Villalobos Alvarado Alma Belen.
    Saucedo Ortiz Cesar Jesus.
    Beltran Arellano Alison Odalis.
*/  
public abstract class LeastSquaresRegressor {
    protected double[][] design;  
    protected double[] y;     
    protected double[] betas;

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
