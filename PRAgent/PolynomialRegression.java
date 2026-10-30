
public class PolynomialRegression extends LeastSquaresRegressor {
    private final int degree;
    public PolynomialRegression(double[] x, double[] y) { this(x, y, 2); }
    public PolynomialRegression(double[] x, double[] y, int degree) {
        this.degree = degree;
        double[][] d = new double[x.length][degree + 1];
        for (int i = 0; i < x.length; i++) d[i] = row(x[i]);
        fit(d, y);
    }
    private double[] row(double x) {
        double[] r = new double[degree + 1];
        for (int k = 0; k <= degree; k++) r[k] = Math.pow(x, k);
        return r;
    }
    public double getBeta0() { return betas[0]; }
    public double getBeta1() { return betas[1]; }
    public double getBeta2() { return betas[2]; }
    public double predict(double x) { return predictRow(row(x)); }
    @Override public String getEquation() {
        StringBuilder sb = new StringBuilder(String.format("y = %.4f", betas[0]));
        for (int k = 1; k <= degree; k++)
            sb.append(String.format(" %s %.4f x%s", betas[k] < 0 ? "-" : "+",
                    Math.abs(betas[k]), k == 1 ? "" : "^" + k));
        return sb.append("  - PR").toString();
    }
}
