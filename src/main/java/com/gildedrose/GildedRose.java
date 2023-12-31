package com.gildedrose;

class GildedRose {

  private static final String BRIE = "Aged Brie";
  private static final String PASS = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
     
      if (item.name.equals(BRIE)) {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;
      }

      else if (item.name.equals(PASS)) {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
        
        if (item.sellIn < 11) {
          if (item.quality < 50) {
            item.quality = item.quality + 1;
          }
        }

        if (item.sellIn < 6) {
          if (item.quality < 50) {
            item.quality = item.quality + 1;
          }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
          item.quality = 0;
        }

      }

      else if (item.name.startsWith("Conjured")) {
        item.sellIn = item.sellIn - 1;

        if (item.quality > 0) {
          item.quality = item.quality - 2; 

          if (item.sellIn < 0) {
            item.quality = item.quality - 2; 
          }
        }
      }

      else if (normalItem(item)) {
        item.sellIn = item.sellIn - 1;

        if (item.quality > 0) {
          item.quality = item.quality - 1;

          if (item.sellIn < 0) {
            item.quality = item.quality - 1;
          }
        }
      }
    }
  }

  private boolean normalItem(Item item) {
    return !item.name.equals(BRIE) && !item.name.equals(PASS) && !item.name.equals(SULFURAS);
  }
}
