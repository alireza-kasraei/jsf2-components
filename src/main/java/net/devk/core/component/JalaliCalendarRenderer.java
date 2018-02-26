package net.devk.core.component;

import java.io.IOException;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.render.FacesRenderer;

import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.WidgetBuilder;

import net.devk.core.converter.jalali.JalaliDateConverter;

@FacesRenderer(componentFamily = JalaliCalendar.COMPONENT_FAMILY, rendererType = JalaliCalendarRenderer.RENDERER_TYPE)
public class JalaliCalendarRenderer extends CoreRenderer {

	public static final String RENDERER_TYPE = "net.devk.faces.JalaliCalendarRenderer";

	@Override
	public void decode(FacesContext context, UIComponent component) {

		JalaliCalendar calendar = (JalaliCalendar) component;
		String param = calendar.getClientId(context);
		String submittedValue = context.getExternalContext().getRequestParameterMap().get(param);

		if (submittedValue != null) {
			calendar.setSubmittedValue(submittedValue);
		}
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		this.encodeMarkup(context, (JalaliCalendar) component);
		this.encodeScript(context, (JalaliCalendar) component);
	}

	private void encodeMarkup(FacesContext context, JalaliCalendar jalaliCalendar) throws IOException {

		ResponseWriter writer = context.getResponseWriter();

		if (jalaliCalendar.isAltField()) {
			writer.startElement("p", null);
			createInputElement(jalaliCalendar, writer);
			writer.startElement("input", jalaliCalendar);
			writer.writeAttribute("type", "text", null);
			writer.writeAttribute("id", jalaliCalendar.getClientId() + "_altField", null);
			writer.writeAttribute("readonly", "true", null);
			writer.writeAttribute("disabled", "true", null);
			writer.writeAttribute("style", "border: none;background: none;outline: 0;", null);
			writer.endElement("input");
			writer.endElement("p");
		} else {
			createInputElement(jalaliCalendar, writer);
		}

	}

	private void createInputElement(JalaliCalendar jalaliCalendar, ResponseWriter writer) throws IOException {
		writer.startElement("input", jalaliCalendar);
		writer.writeAttribute("id", jalaliCalendar.getClientId(), null);
		writer.writeAttribute("name", jalaliCalendar.getClientId(), null);
		writer.writeAttribute("type", "text", null);
		writer.writeAttribute("dir", "ltr", null);
		writer.writeAttribute("class", createStyleClass(jalaliCalendar), "styleClass");
		String style = jalaliCalendar.getStyle();
		if (style != null) {
			writer.writeAttribute("style", style, null);
		}

		int size = jalaliCalendar.getSize();
		if (size > 0) {
			writer.writeAttribute("size", size, null);
		}

		String tabindex = jalaliCalendar.getTabindex();
		if (tabindex != null) {
			writer.writeAttribute("tabindex", tabindex, null);
		}

		String title = jalaliCalendar.getTitle();
		if (title != null) {
			writer.writeAttribute("title", title, null);
		}

		boolean disabled = jalaliCalendar.isDisabled();
		if (disabled) {
			writer.writeAttribute("disabled", disabled, null);
		}

		writer.endElement("input");
	}

	private void encodeScript(FacesContext context, JalaliCalendar component) throws IOException {
		String clientId = component.getClientId();
		String widgetVar = component.resolveWidgetVar();

		WidgetBuilder wb = getWidgetBuilder(context);
		wb.initWithDomReady("JalaliCalendar", widgetVar, clientId);
		wb.attr("changeMonth", component.isChangeMonth(), false);
		wb.attr("changeYear", component.isChangeYear(), false);
		wb.attr("dateFormat", component.getDateFormat());
		wb.attr("showButtonPanel", component.isShowButtonPanel());
		wb.attr("showWeek", component.isShowWeek());
		wb.attr("autoSize", component.isAutoSize());
		wb.attr("numberOfMonths", component.getNumberOfMonths());
		wb.attr("minDate", component.getMinDate());
		wb.attr("maxDate", component.getMaxDate());
		Date value = (Date) component.getValue();
		if (value != null) {
			wb.attr("setDate", net.devk.core.util.JalaliDateUtil.toString((Date) value));
		}
		wb.finish();
	}

	protected String createStyleClass(JalaliCalendar jalaliCalendar) {
		String defaultClass = JalaliCalendar.STYLE_CLASS;
		defaultClass = jalaliCalendar.isValid() ? defaultClass : defaultClass + " ui-state-error";
		defaultClass = !jalaliCalendar.isDisabled() ? defaultClass : defaultClass + " ui-state-disabled";

		String styleClass = jalaliCalendar.getStyleClass();
		styleClass = styleClass == null ? defaultClass : defaultClass + " " + styleClass;

		return styleClass;
	}

	@Override
	public Object getConvertedValue(FacesContext context, UIComponent component, Object value)
			throws ConverterException {
		JalaliCalendar calendar = (JalaliCalendar) component;
		String submittedValue = (String) value;

		if (submittedValue != null) {

			// Delegate to user supplied converter if defined
			try {
				Converter converter = calendar.getConverter();
				if (converter != null) {
					return converter.getAsObject(context, calendar, submittedValue);
				}
			} catch (ConverterException e) {
				throw e;
			}

			JalaliDateConverter jalaliDateConverter = new JalaliDateConverter();
			return jalaliDateConverter.getAsObject(context, calendar, submittedValue);

		}
		return null;

	}
}
