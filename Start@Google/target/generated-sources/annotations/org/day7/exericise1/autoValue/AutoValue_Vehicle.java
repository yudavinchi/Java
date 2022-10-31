package org.day7.exericise1.autoValue;

import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Vehicle extends Vehicle {

  private final String type;

  private final int cost;

  AutoValue_Vehicle(
      String type,
      int cost) {
    if (type == null) {
      throw new NullPointerException("Null type");
    }
    this.type = type;
    this.cost = cost;
  }

  @Override
  String type() {
    return type;
  }

  @Override
  int cost() {
    return cost;
  }

  @Override
  public String toString() {
    return "Vehicle{"
        + "type=" + type + ", "
        + "cost=" + cost
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Vehicle) {
      Vehicle that = (Vehicle) o;
      return this.type.equals(that.type())
          && this.cost == that.cost();
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= type.hashCode();
    h$ *= 1000003;
    h$ ^= cost;
    return h$;
  }

}
