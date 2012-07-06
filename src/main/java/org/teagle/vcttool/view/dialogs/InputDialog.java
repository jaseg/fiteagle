package org.teagle.vcttool.view.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class InputDialog extends Dialog implements SelectionListener {
	
	private String name = "";
	
	private Group params;

	private Button buttonOk;
	private Button buttonCancel;

	public InputDialog(Shell shell, String name) {
		super(shell, name);
		Composite container = getContainer();
		
		params = new Group(container, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		params.setLayout(layout);
		params.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		buttonOk = new Button(container, SWT.PUSH);
	    buttonOk.setText("OK");
	    buttonOk.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false));
	    buttonOk.addSelectionListener(this);

	    buttonCancel = new Button(container, SWT.PUSH);
	    buttonCancel.setText("Cancel");
	    buttonCancel.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false));
	    buttonCancel.addSelectionListener(this);
	}
	
	public void addInputField(String name, String defaultValue, String description) {
	    Label label = new Label(params, SWT.NONE);
	    label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
	    label.setText(name);
	    Text text = new Text(params, SWT.BORDER);
	    text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	    if (defaultValue != null && !defaultValue.isEmpty()) {
	    	text.setText(defaultValue);
	    }
	    
	    text.setData(name);
	    
	    if (description != null && !description.isEmpty()) {
		    label.setToolTipText(description);
		    text.setToolTipText(description);
	    }   
	}
	
	public String getName() {
		return name;
	}

	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void widgetSelected(SelectionEvent event) {
		if (event.widget == buttonOk) {
			for (Control control : params.getChildren()) {
				Object data = control.getData();
				if (data != null) {
					if (control instanceof Text) {
						name = ((Text)control).getText();
					} else if (control instanceof Button) {
//						configParams.put(data.toString(), String.valueOf(((Button)control).getSelection()));
						System.out.println("moep");
					}
				}
			}
			hide(SWT.OK);					
		} else {
			hide(SWT.CANCEL);			
		}
		
	}

}
