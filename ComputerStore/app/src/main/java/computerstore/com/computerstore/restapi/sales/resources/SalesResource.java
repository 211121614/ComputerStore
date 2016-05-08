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
public class SalesResource implements Serializable {

    private String SalesId;
    private int EmpID;
    private String Date;
    private double TotalSales;
    private double Discount;

    public String getSalesId() {
        return SalesId;
    }

    public int getEmpID() {
        return EmpID;
    }

    public String getDate() {
        return Date;
    }

    public double getTotalSales() {
        return TotalSales;
    }

    public double getDiscount() {
        return Discount;
    }

    private SalesResource()
    {

    }

    private SalesResource(Builder builder)
    {
        this.SalesId = builder.SalesId;
        this.EmpID = builder.EmpID;
        this.Date = builder.Date;
        this.TotalSales = builder.TotalSales;
        this.Discount = builder.Discount;
    }

    public  static class Builder
    {
        private String SalesId;
        private int EmpID;
        private String Date;
        private double TotalSales;
        private double Discount;

        public Builder salesId(String SalesId) {
            this.SalesId = SalesId;
            return this;
        }

        public Builder empID(int EmpID) {
            this.EmpID = EmpID;
            return this;
        }

        public Builder date(String Date) {
            this.Date = Date;
            return this;
        }

        public Builder totalSales(double TotalSales) {
            this.TotalSales = TotalSales;
            return this;
        }

        public Builder discount(double Discount) {
            this.Discount = Discount;
            return this;
        }



        public Builder Sales (SalesResource sales)
        {
            this.SalesId = sales.SalesId;
            this.EmpID = sales.EmpID;
            this.Date = sales.Date;
            this.TotalSales = sales.TotalSales;
            this.Discount = sales.Discount;
            return this;
        }

        public SalesResource build ()
        {
            return new SalesResource(this);
        }

    }

}

