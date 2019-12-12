package core.rsolano.liqinterface.view.custom.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.adf.view.rich.model.AttributeDescriptor.ComponentType;

public class GenericTablePageDef {
    public GenericTablePageDef() {
        super();
    }
    
    /**
     * Adds attributes to the pageDef
     */
    public void setupAttributes(List<Object[]> result, List<String> columns)
    {
      _attributes = new HashMap<String, GenericAttributeDef>();
      int index = 0;      
      for(String attribute: columns){ 
          addAttributeDef(attribute, attribute, null, attribute, getWidth(result, index),  getWidth(result, index) + 20, String.class, "columns");
          index++;
      }      
    }

    public void addAttributeDef (String name, String description, String format, String label, int length, int maxLength, Class dataType, String category) {
        GenericAttributeDef attributeDef = new GenericAttributeDef(name, description, format, label, length, maxLength, dataType, category, true);
        _attributes.put(name, attributeDef);
    }

    /**
     * Gets the AttributeDescriptor objects by its name.
     * @return
     */
    public List<GenericAttributeDef> getAttributeDefs()
    {
      if (_attributes != null)
      {
        List<GenericAttributeDef> attrDescList =
          new ArrayList<GenericAttributeDef>(_attributes.values());
        return attrDescList;
      }

      return Collections.emptyList();
    }
    
    public String[] getAttributeNames() {
        return _attributes.keySet().toArray(new String[0]);
    }

    private int getWidth(List<Object[]> result, int index) {
        int width = 10;
        if(result.get(0) instanceof Object[]){
            for(Object[] row: result){
                int newWidth = row[index] != null ? row[index].toString().length() + 10 : 10;
                width = newWidth > width ? newWidth : width; 
            }
        }
        else{
            for(Object row: result){
                int newWidth = row != null ? row.toString().length() + 10 : 10;
                width = newWidth > width ? newWidth : width; 
            }
        }
        return width;
        
    }

    public class GenericAttributeDef {
        public GenericAttributeDef(String name, String description, String format, String label, int length, int maxLength, Class dataType, String category, boolean isReadOnly) {
            _name = name;
            _description = description;
            _format = format;
            _label = label;
            _length = length;
            _maxLength = maxLength;
            _dataType = dataType;
            _category = category;
            _isReadOnly = isReadOnly;
        }
        
        public String getName() {
            return _name;
        }
        
        public String getDescription() {
            return _description;
        }
        
        public String getFormat() {
            return _format;
        }
        
        public String getLabel() {
            return _label;
        }
        
        public int getLength() {
            return _length;
        }
        
        public int getMaxLength() {
            return _maxLength;
        }
        
        public ComponentType getComponentType() {
            return _componentType;
        }
        
        public Class getDataType(){
            return _dataType;
        }
        
        public void setCategory(String category)
        {
          this._category = category;
        }

        public String getCategory()
        {
          return _category;
        }      
        
        public void setIsReadOnly(boolean isReadOnly)
        {
          this._isReadOnly = isReadOnly;
        }

        public boolean isReadOnly()
        {
          return _isReadOnly;
        }      
    
        private String _name;
        private String _description;
        private String _format;
        private String _label;
        private int _length;
        private int _maxLength;
        private ComponentType _componentType;
        private Class _dataType;
        private String _category;  // group name
        private boolean _isReadOnly;
    }
    
    
    // Map of attributes for the page
    private Map<String, GenericAttributeDef> _attributes;
}
