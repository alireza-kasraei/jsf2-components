package net.devk.core.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.Widget;

/**
 * jalali calendar datepicker that wraps jquery ui date picker for using in jsf.
 * 
 * @version 0.0.1
 */

@FacesComponent(value = JalaliCalendar.COMPONENT_TYPE)
@ResourceDependencies({ @ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
		@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
		@ResourceDependency(library = "primefaces", name = "jquery/jquery-plugins.js"),
		@ResourceDependency(library = "primefaces", name = "primefaces.js"),
		@ResourceDependency(library = "core", name = "datepicker/jquery.ui.datepicker-cc.js"),
		@ResourceDependency(library = "core", name = "datepicker/calendar.js"),
		@ResourceDependency(library = "core", name = "datepicker/jquery.ui.datepicker-cc-fa.js"),
		@ResourceDependency(library = "core", name = "datepicker/jalaliCalendar.js"),
		@ResourceDependency(library = "primefaces", name = "primefaces.css") })
public class JalaliCalendar extends UIInput implements Widget {

	public static final String COMPONENT_TYPE = "net.devk.faces.JalaliCalendar";
	public static final String COMPONENT_FAMILY = "net.devk.faces.components";

	public final static String STYLE_CLASS = "ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all";

	protected enum PropertyKeys {

		size, style, styleClass, tabindex, title, disabled, showWeek, dateFormat, altField, showButtonPanel, autoSize, changeMonth, changeYear, numberOfMonths, minDate, maxDate, widgetVar;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {
		}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}

	}

	/**
	 * <p>
	 * Return the value of the <code>size</code> property.
	 * </p>
	 * <p>
	 * Contents: The number of characters used to determine the width of this
	 * field.
	 */
	public int getSize() {
		return (Integer) getStateHelper().eval(PropertyKeys.size, Integer.MIN_VALUE);

	}

	/**
	 * <p>
	 * Set the value of the <code>size</code> property.
	 * </p>
	 */
	public void setSize(int size) {
		getStateHelper().put(PropertyKeys.size, size);
	}

	/**
	 * <p>
	 * Return the value of the <code>style</code> property.
	 * </p>
	 * <p>
	 * Contents: CSS style(s) to be applied when this component is rendered.
	 */
	public String getStyle() {
		return (String) getStateHelper().eval(PropertyKeys.style);

	}

	/**
	 * <p>
	 * Set the value of the <code>style</code> property.
	 * </p>
	 */
	public void setStyle(String style) {
		getStateHelper().put(PropertyKeys.style, style);
	}

	/**
	 * <p>
	 * Return the value of the <code>styleClass</code> property.
	 * </p>
	 * <p>
	 * Contents: Space-separated list of CSS style class(es) to be applied when
	 * this element is rendered. This value must be passed through as the
	 * "class" attribute on generated markup.
	 */
	public String getStyleClass() {
		return (String) getStateHelper().eval(PropertyKeys.styleClass);

	}

	/**
	 * <p>
	 * Set the value of the <code>styleClass</code> property.
	 * </p>
	 */
	public void setStyleClass(String styleClass) {
		getStateHelper().put(PropertyKeys.styleClass, styleClass);
	}

	/**
	 * <p>
	 * Return the value of the <code>tabindex</code> property.
	 * </p>
	 * <p>
	 * Contents: Position of this element in the tabbing order for the current
	 * document. This value must be an integer between 0 and 32767.
	 */
	public String getTabindex() {
		return (String) getStateHelper().eval(PropertyKeys.tabindex);

	}

	/**
	 * <p>
	 * Set the value of the <code>tabindex</code> property.
	 * </p>
	 */
	public void setTabindex(String tabindex) {
		getStateHelper().put(PropertyKeys.tabindex, tabindex);
	}

	/**
	 * <p>
	 * Return the value of the <code>title</code> property.
	 * </p>
	 * <p>
	 * Contents: Advisory title information about markup elements generated for
	 * this component.
	 */
	public String getTitle() {
		return (String) getStateHelper().eval(PropertyKeys.title);

	}

	/**
	 * <p>
	 * Set the value of the <code>title</code> property.
	 * </p>
	 */
	public void setTitle(String title) {
		getStateHelper().put(PropertyKeys.title, title);
	}

	/**
	 * <p>
	 * Return the value of the <code>disabled</code> property.
	 * </p>
	 * <p>
	 * Contents: Flag indicating that this element must never receive focus or
	 * be included in a subsequent submit. A value of false causes no attribute
	 * to be rendered, while a value of true causes the attribute to be rendered
	 * as disabled="disabled".
	 */
	public boolean isDisabled() {
		return (Boolean) getStateHelper().eval(PropertyKeys.disabled, false);

	}

	/**
	 * <p>
	 * Set the value of the <code>disabled</code> property.
	 * </p>
	 */
	public void setDisabled(boolean disabled) {
		getStateHelper().put(PropertyKeys.disabled, disabled);
	}

	public String getDateFormat() {
		return (String) getStateHelper().eval(PropertyKeys.dateFormat);
	}

	public void setDateFormat(String dateFormat) {
		getStateHelper().put(PropertyKeys.dateFormat, dateFormat);
	}

	public void setShowWeek(boolean showWeek) {
		getStateHelper().put(PropertyKeys.showWeek, showWeek);
	}

	public boolean isShowWeek() {
		return (Boolean) getStateHelper().eval(PropertyKeys.showWeek, false);
	}

	public void setAltField(boolean altField) {
		getStateHelper().put(PropertyKeys.altField, altField);
	}

	public boolean isAltField() {
		return (Boolean) getStateHelper().eval(PropertyKeys.altField, false);
	}

	public void setShowButtonPanel(boolean showButtonPanel) {
		getStateHelper().put(PropertyKeys.showButtonPanel, showButtonPanel);
	}

	public boolean isShowButtonPanel() {
		return (Boolean) getStateHelper().eval(PropertyKeys.showButtonPanel, false);
	}

	public void setAutoSize(boolean autoSize) {
		getStateHelper().put(PropertyKeys.autoSize, autoSize);
	}

	public boolean isAutoSize() {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoSize, false);
	}

	public void setChangeMonth(boolean changeMonth) {
		getStateHelper().put(PropertyKeys.changeMonth, changeMonth);
	}

	public boolean isChangeMonth() {
		return (Boolean) getStateHelper().eval(PropertyKeys.changeMonth, false);
	}

	public void setChangeYear(boolean changeYear) {
		getStateHelper().put(PropertyKeys.changeYear, changeYear);
	}

	public boolean isChangeYear() {
		return (Boolean) getStateHelper().eval(PropertyKeys.changeYear, false);
	}

	public void setNumberOfMonths(String numberOfMonths) {
		getStateHelper().put(PropertyKeys.numberOfMonths, numberOfMonths);
	}

	public String getNumberOfMonths() {
		return (String) getStateHelper().eval(PropertyKeys.numberOfMonths, null);
	}

	public void setMinDate(String minDate) {
		getStateHelper().put(PropertyKeys.minDate, minDate);
	}

	public String getMinDate() {
		return (String) getStateHelper().eval(PropertyKeys.minDate, null);
	}

	public void setMaxDate(String maxDate) {
		getStateHelper().put(PropertyKeys.maxDate, maxDate);
	}

	public String getMaxDate() {
		return (String) getStateHelper().eval(PropertyKeys.maxDate, null);
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getWidgetVar() {
		return (String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}

	public void setWidgetVar(String _widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
	}

	@Override
	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if (userWidgetVar != null) {
			return userWidgetVar;
		} else {
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
		}

	}
}
