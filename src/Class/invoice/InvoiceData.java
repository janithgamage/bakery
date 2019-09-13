/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2016 Ricardo Mariaca
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package Class.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class InvoiceData {
        
        private Integer iNo;
	private Integer oNo;
        private String date;
	private List<Items> items;

    public InvoiceData() {
        //createInvoice();
    }

    public Integer getiNo() {
        return iNo;
    }

    public void setiNo(Integer iNo) {
        this.iNo = iNo;
    }

    public Integer getoNo() {
        return oNo;
    }

    public void setoNo(Integer oNo) {
        this.oNo = oNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
        
     

	public void createInvoice() {
		/*setiNo(5);
		setoNo(50);
		setDate("2017/10/10");


		List<Items> items = new ArrayList<Items>();
		items.add(createItem("504","Notebook", 1, new BigDecimal(1000)));
		items.add(createItem("508","DVD", 5, new BigDecimal(40)));
		items.add(createItem("324","Book", 2, new BigDecimal(10)));
		items.add(createItem("157","Phone", 1, new BigDecimal(200)));
		setItems(items);*/
	}

	public Items createItem(String itemNumber, String description, Integer quantity, BigDecimal unitprice) {
		Items item = new Items();
		item.setDescription(description);
		item.setQuantity(quantity);
		item.setUnitprice(unitprice);
                item.setItemNumber(itemNumber);
		return item;
	}

	public JRDataSource createDataSource() {
		return new JRBeanCollectionDataSource(getItems());
	}
}
