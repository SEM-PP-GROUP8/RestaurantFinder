package com.group8.model;

public enum RestaurantType {
    INDIAN("Indian"),FAST_FOOD("Fastfood");
    
    private String value;
    
    private RestaurantType(String value){
        this.value = value;
    }
    
    @Override
    public String toString(){
        return this.value;
    }
    
    public static RestaurantType findConstantByValue(String value){
        
        for(RestaurantType rt : values()){
            if(rt.toString().equals(value))
                return rt;
        }
        
        return null;
    }
    
}
