package app;

public enum TestData {
    CUSTOMER_FORM_DATA(new CustomerFormData(
            "Teste Sicredi",
            "Teste",
            "Victor Araujo",
            "51 9999-9999",
            "Av Assis Brasil, 3970",
            "Torre D",
            "Porto Alegre",
            "RS",
            "91000-000",
            "Brasil",
            "0001",
            "200"
    ));

    private CustomerFormData formData;

    TestData(CustomerFormData formData) {
        this.formData = formData;
    }

    public CustomerFormData getFormData() {
        return formData;
    }
}