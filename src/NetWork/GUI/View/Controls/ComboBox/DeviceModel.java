package NetWork.GUI.View.Controls.ComboBox;

import NetWork.Data.Database.Models.Device;
import NetWork.Data.Database.Service.DatabaseService;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;

public class DeviceModel implements MutableComboBoxModel {

    protected ArrayList<Device> deviceList;

    protected Device selectedItem;

    public DeviceModel() {
        deviceList = DatabaseService.getService().GetDeviceList();
    }

    @Override
    public void addElement(Object item) {

    }

    @Override
    public void removeElement(Object obj) {

    }

    @Override
    public void insertElementAt(Object item, int index) {

    }

    @Override
    public void removeElementAt(int index) {

    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem = (Device) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }

    @Override
    public int getSize() {
        return deviceList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return deviceList.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
