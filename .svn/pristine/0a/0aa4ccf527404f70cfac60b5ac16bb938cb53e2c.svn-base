package core.rsolano.liqinterface.view.custom.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.model.AttributeDescriptor.ComponentType;
import oracle.adf.view.rich.model.BaseAttributeDescriptor;
import oracle.adf.view.rich.model.AttributesModel;

import oracle.adf.view.rich.model.Descriptor;

import oracle.adf.view.rich.model.GroupAttributeDescriptor;
import core.rsolano.liqinterface.view.custom.objects.GenericTablePageDef.GenericAttributeDef;

public class GenericTable {
    public GenericTable() {        
    }

    public GenericTable(List<Object[]> result, List<String> columns) {
        CreatePageDef(result, columns);
        _attrsModel = new GenericAttributesModel();
        SetupData(result, columns);
    }

    public AttributesModel getAttributesModel() {
        return _attrsModel;
    }

    public Map[] getValues() {
        return _DATA;
    }

    public Map getValue() {
        return _DATA[currentRowIndex];
    }

    public void next(ActionEvent actionEvent) {
        if (currentRowIndex < _DATA.length - 1)
            currentRowIndex++;
    }

    public boolean getNextEnabled() {
        return (currentRowIndex < (_DATA.length - 1));
    }

    public void previous(ActionEvent actionEvent) {
        if (currentRowIndex > 0)
            currentRowIndex--;
    }

    public boolean getPreviousEnabled() {
        return currentRowIndex > 0;
    }

    /**
     * Creates a DemoPageDef object, containing a list of attributes, saved searches and each saved
     * search definintion object containing a list of search field definitions.
     */
    public void CreatePageDef(List<Object[]> result, List<String> columns) {
        _pageDef = new GenericTablePageDef();
        _pageDef.setupAttributes(result, columns);
    }

    public void SetupData(List<Object[]> result, List<String> columns) {
        
        _DATA = new Map[result.size()];
        try {
            int rowNumber = 0;
            if(result.get(0) instanceof Object[]){
                for(Object[] row: result){                            
                    AddOneRow(row, rowNumber, columns);
                    rowNumber++;
                }
            }
            else{
                for(Object row: result){                            
                    AddOneRow(row, rowNumber, columns);
                    rowNumber++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void AddOneRow(Object obj, int rowNumber, List<String> columns) {
        Map rowData = new HashMap<String, Object>(1);
        int index = 0;
        String aux = obj != null ? obj.toString() : "null";            
        rowData.put(columns.get(index), aux);
        _DATA[rowNumber] = rowData;
        return;
    }

    private void AddOneRow(Object[] row, int rowNumber, List<String> columns) {
        Map rowData = new HashMap<String, Object>(row.length);
        int index = 0;
        for(Object obj : row){                        
            String aux = obj != null ? obj.toString() : "null";            
            rowData.put(columns.get(index), aux);
            index++;
        }                                    
        _DATA[rowNumber] = rowData;
        return;
    }

    public class GenericAttributesModel extends AttributesModel {
        public GenericAttributesModel() {
            _flatAttributes = new ArrayList<BaseAttributeDescriptor>();
            _hierAttributes = new ArrayList<Descriptor>();
            _setupAttributesFromDefinition();
        }

        public List<BaseAttributeDescriptor> getAttributes() {
            return _flatAttributes;
        }

        public List<Descriptor> getHierarchicalAttributes() {
            return _hierAttributes;
        }

        public List<BaseAttributeDescriptor> getLinkedViewAttributes(String string) {
            return Collections.emptyList();
        }

        private void _setupAttributesFromDefinition() {
            Map<String, List<BaseAttributeDescriptor>> groupMap = new HashMap<String, List<BaseAttributeDescriptor>>();

            List<GenericTablePageDef.GenericAttributeDef> attributeList = _pageDef.getAttributeDefs();

            for (GenericTablePageDef.GenericAttributeDef demoAttrDef : attributeList) {
                GenericAttributeDescriptor attrDesc = new GenericAttributeDescriptor(demoAttrDef);
                _flatAttributes.add(attrDesc);
                String groupName = attrDesc.getGroupName();
                if (groupName != null && !groupName.isEmpty()) {
                    List<BaseAttributeDescriptor> list = groupMap.get(groupName);
                    if (list == null) {
                        list = new ArrayList<BaseAttributeDescriptor>();
                        groupMap.put(groupName, list);
                    }
                    list.add(attrDesc);
                } else {
                    _hierAttributes.add(attrDesc);
                }
            }

            for (String groupName : groupMap.keySet()) {
                GenericGroupAttributeDescriptor groupMetadata =
                    new GenericGroupAttributeDescriptor(groupName, groupMap.get(groupName));
                _hierAttributes.add(groupMetadata);
            }
        }

        private List<BaseAttributeDescriptor> _flatAttributes = null;
        private List<Descriptor> _hierAttributes = null;

        public String getName() {
            return null;
        }

        public List<BaseAttributeDescriptor> getGroupAttributes(String string) {
            return Collections.emptyList();
        }
    }

    public class GenericAttributeDescriptor extends BaseAttributeDescriptor {
        public GenericAttributeDescriptor(GenericAttributeDef attributeDef) {
            _attributeDef = attributeDef;
        }

        public Object getId() {
            return getName();
        }

        public String getName() {
            return _attributeDef.getName();
        }

        public String getGroupName() {
            return _attributeDef.getCategory();
        }

        public Class getDataType() {
            return _attributeDef.getDataType();
        }

        public String getDescription() {
            return _attributeDef.getDescription();
        }

        public String getLabel() {
            return _attributeDef.getLabel();
        }

        public int getLength() {
            return _attributeDef.getLength();
        }

        public int getMaximumLength() {
            return _attributeDef.getMaxLength();
        }

        @Override
        public String getFormat() {
            return null;
        }

        @Override
        public boolean isRequired() {
            return false;
        }

        @Override
        public boolean isReadOnly() {
            return false;
        }

        @Override
        public Class getType() {
            return _attributeDef.getDataType();
        }

        @Override
        public ComponentType getComponentType() {
            return _getComponentTypeByDatatype();
        }

        @Override
        public Object getModel() {
            return null;
        }

        private ComponentType _getComponentTypeByDatatype() {
            Class cls = getType();


            if (cls == java.sql.Date.class || cls == java.sql.Time.class || cls == java.sql.Timestamp.class) {
                return ComponentType.inputDate;
            }

            return ComponentType.inputText;
        }


        private GenericAttributeDef _attributeDef;
    }

    public class GenericGroupAttributeDescriptor extends GroupAttributeDescriptor {
        public GenericGroupAttributeDescriptor(String groupName, List<BaseAttributeDescriptor> attributeList) {
            _groupName = groupName;
            _flatAttributes = attributeList;
        }


        @Override
        public String getName() {
            return _groupName;
        }

        public List<? extends Descriptor> getDescriptors() {
            return _flatAttributes;
        }

        public String getDescription() {
            return "This is a group";
        }

        public String getLabel() {
            return _groupName;
        }


        private List<BaseAttributeDescriptor> _flatAttributes;
        private String _groupName;

    }

    private GenericTablePageDef _pageDef;
    private GenericAttributesModel _attrsModel;
    private int currentRowIndex = 0;
    private static Map[] _DATA;
}
