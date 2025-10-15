package com.restaurant.domain;

public class Restaurant {
  private static long N_RESTAURANT = 0;

  private long id;
  private String name;
  private String location;

  public Restaurant(String name, String location) {
    this.id = N_RESTAURANT++;
    this.name = name;
    this.location = location;
  }

  public long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getLocation() {
    return this.location;
  }
}
