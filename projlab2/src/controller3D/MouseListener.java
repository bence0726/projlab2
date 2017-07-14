package controller3D;

import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

public class MouseListener extends MouseEvent {

	public MouseListener(Object source, EventTarget target, EventType<? extends MouseEvent> eventType, double x,
			double y, double screenX, double screenY, MouseButton button, int clickCount, boolean shiftDown,
			boolean controlDown, boolean altDown, boolean metaDown, boolean primaryButtonDown, boolean middleButtonDown,
			boolean secondaryButtonDown, boolean synthesized, boolean popupTrigger, boolean stillSincePress,
			PickResult pickResult) {
		super(source, target, eventType, x, y, screenX, screenY, button, clickCount, shiftDown, controlDown, altDown, metaDown,
				primaryButtonDown, middleButtonDown, secondaryButtonDown, synthesized, popupTrigger, stillSincePress,
				pickResult);
		// TODO Auto-generated constructor stub
	}

	

}
