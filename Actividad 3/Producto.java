class Producto {
    private String codigo;
    private String tipo;
    private double costo;
    private double impuesto;
    public Producto() {}
    public String getCodigo() {
        return codigo;
    }
    public String getTipo() {
        return tipo;
    }
    public double getCosto() {
        return costo;
    }
    public double getImpuesto() {
        return impuesto;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
    public void muestraProducto() {
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Costo: $" + costo);
        System.out.println("Impuesto: " + impuesto + "%");
    }
    public double calcularPrecio(double utilidad) {
        double precioAntesImpuesto = costo + (costo * utilidad / 100);
        double precioFinal = precioAntesImpuesto + (precioAntesImpuesto * impuesto / 100);
        return precioFinal;
    }
}
