
function handleEnterEvent(evt) {
    var _keyCode = evt.getKeyCode();
    if(_keyCode == AdfKeyStroke.ENTER_KEY )
    {
        var comp = evt.getSource();
        AdfCustomEvent.queue(comp, "EnterEvent",{fvalue:comp.getSubmittedValue()}, false);
        evt.cancel();
    }
}

function sayHello(event)
{
    alert("Hello, world!");
}

/*function ChangeBackground(event) {
        var dark = "color:Blue; font-size:small; font-weight:bold; background-color:Highlight; padding-bottom:5px; padding-left:15px; padding-right:15px; padding-top:5px;";
        var light = "color:WindowText; font-size:small; font-weight:bold;background-color:Scrollbar; padding-bottom:5px; padding-left:15px; padding-right:15px; padding-top:5px;";
        var component1 = "";
        var component2 = "";
        var component3 = "";
        var itemComponent = event.getSource();
        itemComponent.setProperty("inlineStyle", dark);
        
        alert(itemComponent.get);
        
        if(itemComponent.getId() == "niControl"){
            component1 = AdfPage.PAGE.findComponentByAbsoluteId("np1:niSecurity");
            component2 = AdfPage.PAGE.findComponentByAbsoluteId("np1:niRegistry");
            component3 = AdfPage.PAGE.findComponentByAbsoluteId("np1:cnReport");
            component1.setProperty("inlineStyle", light);
            component2.setProperty("inlineStyle", light);
            component3.setProperty("inlineStyle", light);
        
        }else if(itemComponent.getId() == "niSecurity"){
        
            component1 = AdfPage.PAGE.findComponentByAbsoluteId("np1:niControl");
            component2 = AdfPage.PAGE.findComponentByAbsoluteId("np1:niRegistry");
            component3 = AdfPage.PAGE.findComponentByAbsoluteId("np1:cnReport");
            component1.setProperty("inlineStyle", light);
            component2.setProperty("inlineStyle", light);
            component3.setProperty("inlineStyle", light);
            
        }else if(itemComponent.getId() == "niRegistry"){
        
            component1 = AdfPage.PAGE.findComponentByAbsoluteId("np1:niControl");
            component2 = AdfPage.PAGE.findComponentByAbsoluteId("np1:niSecurity");
            component3 = AdfPage.PAGE.findComponentByAbsoluteId("np1:cnReport");
            component1.setProperty("inlineStyle", light);
            component2.setProperty("inlineStyle", light);
            component3.setProperty("inlineStyle", light);
            
        }else if(itemComponent.getId() == "cnReport"){
        
            component1 = AdfPage.PAGE.findComponentByAbsoluteId("np1:niControl");
            component2 = AdfPage.PAGE.findComponentByAbsoluteId("np1:niSecurity");
            component3 = AdfPage.PAGE.findComponentByAbsoluteId("np1:niRegistry");
            component1.setProperty("inlineStyle", light);
            component2.setProperty("inlineStyle", light);
            component3.setProperty("inlineStyle", light);
        }
}*/


