package com.example.myapplication;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.annotation.WebServlet;

import com.github.javafaker.Faker;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.HeaderCell;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
// @Widgetset("com.example.myapplication.MyAppWidgetset")
// @Widgetset("com.vaadin.DefaultWidgetSet")
//@Push
public class MyUI extends UI {

	static List<Product> prods;
	private CssLayout rootLayout;

	static {
		Faker f = new Faker();
		prods = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			Product p = new Product(new BigInteger(i + ""));
			p.code = f.code().isbn10();
			p.name = f.commerce().productName();
			p.lotSize = f.number().numberBetween(1, 25);
			p.lotUnit = f.options().option("pcs", "boxes", "truckloads");
			p.weight = new BigDecimal("" + f.number().numberBetween(80, 1200));
			p.weightUnit = f.options().option("grams", "kg", "tons");
			p.width = new BigDecimal("" + f.number().numberBetween(1, 200));
			p.height = new BigDecimal("" + f.number().numberBetween(1, 200));
			p.depth = new BigDecimal("" + f.number().numberBetween(1, 200));
			p.dimensionsUnit = f.options().option("mm", "cm", "meters");
			p.volume = new BigDecimal("" + f.number().numberBetween(1, 200));
			p.volumeUnit = f.options().option("dl", "liter", "m³");
			p.created = f.date().past(1000, TimeUnit.DAYS);
			p.update = f.date().past(500, TimeUnit.DAYS);
			prods.add(p);
		}
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		long startTime = System.currentTimeMillis();
		CssLayout navigation = new CssLayout();
		navigation.addStyleName("nav");
		navigation.setHeight("100%");
		navigation.addComponent(new Button("T", e -> {
			if (rootLayout.getStyleName().contains("nav-expanded")) {
				rootLayout.removeStyleName("nav-expanded");
			} else {
				rootLayout.addStyleName("nav-expanded");
			}
		}));

		Grid grid = createGrid();
		grid.setSizeFull();
		CssLayout gridWrapper = new CssLayout(grid);
		gridWrapper.addStyleName("grid-wrapper");
		gridWrapper.setHeight("100%");
		rootLayout = new CssLayout(navigation, gridWrapper);

		rootLayout.setSizeFull();
		rootLayout.addStyleName("root-layout");

		setContent(rootLayout);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("time it took to create the UI: " + elapsedTime);
	}

	private Grid createGrid() {
		Grid grid = new Grid();
		grid.setSizeFull();
		grid.setHeightUndefined();
		BeanItemContainer container = new BeanItemContainer<>(Product.class);

		populateContainer(container);

		grid.setContainerDataSource(container);
		grid.setColumnOrder("id", "code", "name", "lotSize", "lotUnit", "weight", "weightUnit", "width", "height",
				"depth", "dimensionsUnit", "volume", "volumeUnit", "update", "created", "strProp1", "strProp2",
				"strProp3", "strProp4", "strProp5", "strProp6", "strProp7", "strProp8");
		grid.setEditorEnabled(true);

		return grid;
	}

	private void populateContainer(BeanItemContainer container) {
		long startTime = System.currentTimeMillis();
		container.addAll(getDummyData());
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("time it took to populate the container: " + elapsedTime);
	}

	private List<Product> getDummyData() {
		return prods;
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
