package com.xuyuan;

import com.xuyuan.service.User;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class StringToUserPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

    @Override
    public void setAsText(String text) throws java.lang.IllegalArgumentException {
        User user = new User();
        user.setName(text);
        this.setValue(user);
    }
}
