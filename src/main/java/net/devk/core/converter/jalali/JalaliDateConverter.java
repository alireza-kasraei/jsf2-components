package net.devk.core.converter.jalali;

import java.text.ParseException;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import net.devk.core.util.JalaliDateUtil;

public class JalaliDateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return JalaliDateUtil.toDate(value);
		} catch (ParseException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return JalaliDateUtil.toString((Date) value);
	}

}
