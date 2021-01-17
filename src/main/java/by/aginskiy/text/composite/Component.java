package by.aginskiy.text.composite;

public interface Component {
    Component get(int index);

    void set(int index, Component component);

    void add(Component component);

    void remove(Component component);

    int size();

    String toString();

    TextLayer getLayer();

    int getLayersCount();
}
