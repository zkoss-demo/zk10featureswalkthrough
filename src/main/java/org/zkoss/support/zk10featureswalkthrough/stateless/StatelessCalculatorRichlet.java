package org.zkoss.support.zk10featureswalkthrough.stateless;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.zkoss.stateless.annotation.Action;
import org.zkoss.stateless.annotation.ActionVariable;
import org.zkoss.stateless.annotation.RichletMapping;
import org.zkoss.stateless.sul.IAnyGroup;
import org.zkoss.stateless.sul.IComponent;
import org.zkoss.stateless.sul.IDiv;
import org.zkoss.stateless.sul.IHlayout;
import org.zkoss.stateless.sul.ILabel;
import org.zkoss.stateless.sul.ISeparator;
import org.zkoss.stateless.sul.ISeparatorBase.Orient;
import org.zkoss.stateless.sul.IStyle;
import org.zkoss.stateless.sul.ITextbox;
import org.zkoss.stateless.sul.IHlayout.VerticalAlign;
import org.zkoss.stateless.ui.Locator;
import org.zkoss.stateless.ui.StatelessRichlet;
import org.zkoss.stateless.ui.UiAgent;
import org.zkoss.stateless.ui.util.Immutables;
import org.zkoss.zk.ui.event.Events;

@RichletMapping("/1-stateless/endpoint/calculator")
public class StatelessCalculatorRichlet implements StatelessRichlet{

	private static final String DEMO_CSS = "/1-stateless/css/calculator.css";

	
	@RichletMapping("")
	public List<IComponent> index() {
		Iterable<? extends IAnyGroup> footerChildren = Immutables.createComponents("/1-stateless/zul-template/footer.zul", Collections.singletonMap("targetUrl", "https://www.zkoss.org/wiki/Small_Talks/2023/October/New_Features_of_ZK_10.0.0-Beta"));
		List<IComponent> pageContent = Arrays.asList(
			IStyle.ofSrc(DEMO_CSS),
			renderHeaderLine(),
			ISeparator.ofOrient(Orient.HORIZONTAL),
			IHlayout.of(
				CalculatorTemplates.getDecoratedIntInput("first"),
				CalculatorTemplates.getDecoratedIntInput("second")
			),
			ISeparator.ofOrient(Orient.HORIZONTAL),
			CalculatorTemplates.OPERATION_CONTROLS,
			ISeparator.ofOrient(Orient.HORIZONTAL),
			IDiv.ofId("footer").withChildren(footerChildren)
		);
		return pageContent;
	}

	@Action(from = "#add", type = Events.ON_CLICK)
	public void doAdd(@ActionVariable(targetId = "first", field = "value") int first, @ActionVariable(targetId = "second", field = "value") int second) {
		String resultValue = String.valueOf(first + second);
		UiAgent.getCurrent().smartUpdate(Locator.ofId("result"), new ITextbox.Updater().value(resultValue));
	}
	
	@Action(from = "#substract", type = Events.ON_CLICK)
	public void doSubstract(@ActionVariable(targetId = "first", field = "value") int first, @ActionVariable(targetId = "second", field = "value") int second) {
		String resultValue = String.valueOf(first - second);
		UiAgent.getCurrent().smartUpdate(Locator.ofId("result"), new ITextbox.Updater().value(resultValue));
	}
	
	@Action(from = "#multiply", type = Events.ON_CLICK)
	public void doMultiply(@ActionVariable(targetId = "first", field = "value") int first, @ActionVariable(targetId = "second", field = "value") int second) {
		String resultValue = String.valueOf(first * second);
		UiAgent.getCurrent().smartUpdate(Locator.ofId("result"), new ITextbox.Updater().value(resultValue));
	}
	
	@Action(from = "#divide", type = Events.ON_CLICK)
	public void doDivide(@ActionVariable(targetId = "first", field = "value") int first, @ActionVariable(targetId = "second", field = "value") int second) {
		String resultValue = String.valueOf(Double.valueOf(first) / Double.valueOf(second));
		UiAgent.getCurrent().smartUpdate(Locator.ofId("result"), new ITextbox.Updater().value(resultValue));
	}

	private IComponent renderHeaderLine() {
		return IHlayout.of(
				ILabel.of("Calculator's result: "),
				ITextbox.of("").withId("result").withReadonly(true)
			).withValign(VerticalAlign.MIDDLE);
	}
	
}
