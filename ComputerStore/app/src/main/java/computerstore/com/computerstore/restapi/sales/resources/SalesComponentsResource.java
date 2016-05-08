package computerstore.com.computerstore.restapi.sales.resources;

/**
 * Created by Aidem on 2016/04/17.
 */

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Aidem
 */
public class SalesComponentsResource implements Serializable {

    private String ProductNumber;
    private String SaleID;
    private int amount;

    public String getProductNumber() {
        return ProductNumber;
    }

    public String getSaleID() {
        return SaleID;
    }

    public int getAmount() {
        return amount;
    }

    private SalesComponentsResource()
    {

    }

    private SalesComponentsResource(Builder builder)
    {
        this.ProductNumber = builder.ProductNumber;
        this.SaleID = builder.SaleID;
        this.amount = builder.amount;
    }

    public static class Builder
    {
        private String ProductNumber;
        private String SaleID;
        private int amount;

        public Builder productNumber(String ProductNumber) {
            this.ProductNumber = ProductNumber;
            return this;
        }

        public Builder saleID(String SaleID) {
            this.SaleID = SaleID;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder SalesComponents(SalesComponentsResource salesComponents)
        {
            this.ProductNumber = salesComponents.ProductNumber;
            this.SaleID = salesComponents.SaleID;
            this.amount = salesComponents.amount;
            return this;
        }

        public SalesComponentsResource build()
        {
            return new SalesComponentsResource(this);
        }


    }
}

