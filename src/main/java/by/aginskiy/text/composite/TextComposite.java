package by.aginskiy.text.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {

    private TextLayer layer;
    private Separator separator;
    private List<Component> components;

    public TextComposite(TextLayer layer, Separator separator) {
        this.layer = layer;
        this.separator = separator;
        this.components = new ArrayList<>();
    }

    @Override
    public TextLayer getLayer() {
        return layer;
    }

    @Override
    public Component get(int index) {
        return components.get(index);
    }

    @Override
    public void set(int index, Component component) {
        components.set(index, component);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public int size() {
        return components.size();
    }

    @Override
    public int getLayersCount() {
        return components.get(0).getLayersCount() + 1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");;
        for(Component component : components) {
            String componentStr = component.toString();
            sb.append(componentStr);
            sb.append(separator.getSeparator());
        }
        return sb.toString();
    }
}
