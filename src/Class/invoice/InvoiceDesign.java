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

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class InvoiceDesign {
	private InvoiceData data;

    public InvoiceDesign(InvoiceData data) {
        this.data = data;
    }
	private AggregationSubtotalBuilder<BigDecimal> totalSum;

	public JasperReportBuilder build() throws DRException {
		JasperReportBuilder report = report();

		//init styles
		StyleBuilder columnStyle = stl.style(Templates.columnStyle)
			.setBorder(stl.pen1Point());
		StyleBuilder subtotalStyle = stl.style(columnStyle)
			.bold();
		StyleBuilder shippingStyle = stl.style(Templates.boldStyle)
			.setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT);

		//init columns
		TextColumnBuilder<Integer> rowNumberColumn = col.reportRowNumberColumn()
			.setFixedColumns(2)
			.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
		TextColumnBuilder<String> descriptionColumn = col.column("Description", "description", type.stringType())
			.setFixedWidth(250);
		TextColumnBuilder<String> itemNumberColumn = col.column("Item Number", "itemNumber", type.stringType());
		TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType())
			.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
		TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit Price", "unitprice", Templates.currencyType);
		/*TextColumnBuilder<String> taxColumn = col.column("Tax", exp.text("20%"))
			.setFixedColumns(3);
		//price = unitPrice * quantity
		TextColumnBuilder<BigDecimal> priceColumn = unitPriceColumn.multiply(quantityColumn)
			.setTitle("Price")
			.setDataType(Templates.currencyType);
		//vat = price * tax
		TextColumnBuilder<BigDecimal> vatColumn = priceColumn.multiply(data.getInvoice().getTax())
			.setTitle("VAT")
			.setDataType(Templates.currencyType);
		//total = price + vat*/
		TextColumnBuilder<BigDecimal> totalColumn = unitPriceColumn.multiply(quantityColumn)
			.setTitle("Total Price")
			.setDataType(Templates.currencyType)
			.setRows(2)
			.setStyle(subtotalStyle);
		//init subtotals
		totalSum = sbt.sum(totalColumn)
			.setLabel("Total:")
			.setLabelStyle(Templates.boldStyle);

		//configure report
		report
			.setTemplate(Templates.reportTemplate)
			.setColumnStyle(columnStyle)
			.setSubtotalStyle(subtotalStyle)
			//columns
			.columns(
				rowNumberColumn, itemNumberColumn, descriptionColumn, quantityColumn, unitPriceColumn, totalColumn)
			.columnGrid(
				rowNumberColumn, itemNumberColumn, descriptionColumn, quantityColumn, unitPriceColumn,
				grid.horizontalColumnGridList()
					.add(totalColumn).newRow())
                        .subtotalsAtSummary(
				totalSum)
			//band components
			.title(
				Templates.createTitleComponent(""),
				cmp.horizontalList().setStyle(stl.style(10)).setGap(50).add(
					cmp.hListCell(createInvoiceComponent("", data)).heightFixedOnTop()))
			.pageFooter(
				Templates.footerComponent)
			.summary(
				cmp.horizontalList(
					cmp.text(new TotalPaymentExpression()).setStyle(Templates.bold12CenteredStyle)),
				cmp.verticalGap(30),
				cmp.text("Thank you for your business").setStyle(Templates.bold12CenteredStyle))
			.setDataSource(data.createDataSource());

		return report;
	}

	private ComponentBuilder<?, ?> createInvoiceComponent(String label, InvoiceData invoice) {
		HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));
		addInvoiceAttribute(list, "Invoice No", invoice.getiNo().toString());
		addInvoiceAttribute(list, "Order No", invoice.getoNo().toString());
		addInvoiceAttribute(list, "Invoice Date", invoice.getDate());
		return cmp.verticalList(
							cmp.text(label).setStyle(Templates.boldStyle),
							list);
	}

	private void addInvoiceAttribute(HorizontalListBuilder list, String label, String value) {
		if (value != null) {
			list.add(cmp.text(label + ":").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(value)).newRow();
		}
	}

	private class TotalPaymentExpression extends AbstractSimpleExpression<String> {
		private static final long serialVersionUID = 1L;

		@Override
		public String evaluate(ReportParameters reportParameters) {
			BigDecimal total = reportParameters.getValue(totalSum);
			BigDecimal shipping = new BigDecimal(BigInteger.ONE);
			return "";
		}
	}

        public void design(){
            try {
			JasperReportBuilder report = this.build();
			report.show(false);
		} catch (DRException e) {
			e.printStackTrace();
		}
        }
	public static void main(String[] args) {
		//InvoiceDesign design = new InvoiceDesign();
		
	}
}