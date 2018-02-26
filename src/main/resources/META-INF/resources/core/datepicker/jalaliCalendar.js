PrimeFaces.widget.JalaliCalendar = PrimeFaces.widget.BaseWidget.extend({
	init : function(cfg) {
		this._super(cfg);
		this.input = jQuery(this.jqId);
		this.showWeek = cfg.showWeek;
		this.input.datepicker({
			changeMonth : cfg.changeMonth,
			changeYear : cfg.changeYear,
			showWeek : cfg.showWeek,
			dateFormat : cfg.dateFormat,
			showButtonPanel : cfg.showButtonPanel,
			autoSize : cfg.autoSize,
			numberOfMonths : cfg.numberOfMonths,
			minDate : cfg.minDate,
			maxDate : cfg.maxDate,
			altField : this.jqId + '_altField',
			altFormat : 'DD، d MM yy',
			regional : 'fa'
		});
		this.input.datepicker('setDate', cfg.setDate);
		$.mask.definitions['~'] = "[+-]";
		this.input.datepicker().mask("9999/99/99");

	}
});