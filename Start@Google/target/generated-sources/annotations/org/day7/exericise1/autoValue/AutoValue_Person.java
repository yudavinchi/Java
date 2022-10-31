package org.day7.exericise1.autoValue;

import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Person extends Person {

  private final int id;

  private final String name;

  AutoValue_Person(
      int id,
      String name) {
    this.id = id;
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
  }

  @Override
  int id() {
    return id;
  }

  @Override
  String name() {
    return name;
  }

  @Override
  public String toString() {
    return "Person{"
        + "id=" + id + ", "
        + "name=" + name
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Person) {
      Person that = (Person) o;
      return this.id == that.id()
          && this.name.equals(that.name());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= id;
    h$ *= 1000003;
    h$ ^= name.hashCode();
    return h$;
  }

}
