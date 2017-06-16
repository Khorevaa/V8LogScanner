package org.v8LogScanner.rgx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.v8LogScanner.commonly.Filter;

public class StrokeFilter implements Filter<String>{
  
  private List<String> elements = new ArrayList<>();
  private static final long serialVersionUID = -5249716837573681233L;
  private ComparisonTypes comparisonType = ComparisonTypes.equal;  
  
  @Override
  public Filter<String> add(String val){
    elements.add(val);
    return this;
  }
  
  @Override
  public  boolean isActive(){
    return elements.size()>0;
  }
  
  @Override
  public void reset(){
    elements.clear();
  }
  
  @Override
  public int size(){
    return elements.size();
  }
  
  @Override
  public String get(int index){
    return elements.get(index);
  }
  
  @Override
  public Iterator<String> iterator() {
    return elements.iterator();
  }
  
  @Override
  public List<String> getElements() {
    return elements;
  }
  
  @Override
  public void setElements(List<String> elements) {
    this.elements = elements;
  }

  @Override
  public ComparisonTypes getComparisonType() {
    return comparisonType;
  }

  @Override
  public void setComparisonType(ComparisonTypes comparisonType) {
    this.comparisonType = comparisonType;
  }
}

