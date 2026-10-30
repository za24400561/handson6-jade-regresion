/*Equipo:
    Villalobos Alvarado Alma Belen.
    Saucedo Ortiz Cesar Jesus.
    Beltran Arellano Alison Odalis.
*/  
public class SimpleLinearRegression extends LeastSquaresRegressor {
    public SimpleLinearRegression(double[] x, double[] y) {
        double[][] d = new double[x.length][2];
        for (int i = 0; i < x.length; i++) { d[i][0] = 1; d[i][1] = x[i]; }
        fit(d, y);
    }
    public double getBeta0() { return betas[0]; }
    public double getBeta1() { return betas[1]; }
    public double predict(double x) { return predictRow(new double[]{1, x}); }
    @Override public String getEquation() {
        return String.format("y = %.4f + %.4f x  - SLR", betas[0], betas[1]);
    }
}
