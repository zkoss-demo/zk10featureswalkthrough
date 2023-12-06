package org.zkoss.support.zk10featureswalkthrough.stateless;

import org.zkoss.stateless.sul.IButton;
import org.zkoss.stateless.sul.IHlayout;
import org.zkoss.stateless.sul.IIntbox;
import org.zkoss.stateless.sul.ILabel;
import org.zkoss.stateless.sul.IVlayout;
import org.zkoss.zul.Hlayout;

public class CalculatorTemplates {

	public static final IHlayout OPERATION_CONTROLS = IHlayout.of(
				IButton.of("+").withId("add"),
				IButton.of("-").withId("substract"),
				IButton.of("*").withId("multiply"),
				IButton.of("/").withId("divide")
			);

	public static IVlayout getDecoratedIntInput(String string) {
		return IVlayout.of(
				ILabel.of(string + " member").withSclass("input-field-label"),
				IIntbox.ofId(string).withValue(0).withSclass("input-field-real")
				).withSclass("input-field");
	}

}
