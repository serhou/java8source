/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javafx.scene.control.cell;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

/**
 * A class containing a {@link TableCell} implementation that draws a 
 * {@link TextField} node inside the cell.
 * 
 * <p>By default, the TextFieldTableCell is rendered as a {@link Label} when not
 * being edited, and as a TextField when in editing mode. The TextField will, by 
 * default, stretch to fill the entire table cell.
 * 
 * @param <T> The type of the elements contained within the TreeTableColumn.
 * @since JavaFX 8.0
 */
public class TextFieldTreeTableCell<S,T> extends TreeTableCell<S,T> {
    
    /***************************************************************************
     *                                                                         *
     * Static cell factories                                                   *
     *                                                                         *
     **************************************************************************/
    
    /**
     * Provides a {@link TextField} that allows editing of the cell content when
     * the cell is double-clicked, or when 
     * {@link javafx.scene.control.TreeTableView#edit(int, javafx.scene.control.TreeTableColumn)} is called.
     * This method will only  work on {@link TreeTableColumn} instances which are of
     * type String.
     * 
     * @return A {@link Callback} that can be inserted into the 
     *      {@link TreeTableColumn#cellFactoryProperty() cell factory property} of a 
     *      TreeTableColumn, that enables textual editing of the content.
     */
    public static <S> Callback<TreeTableColumn<S,String>, TreeTableCell<S,String>> forTreeTableColumn() {
        return forTreeTableColumn(new DefaultStringConverter());
    }
    
    /**
     * Provides a {@link TextField} that allows editing of the cell content when
     * the cell is double-clicked, or when 
     * {@link javafx.scene.control.TreeTableView#edit(int, javafx.scene.control.TreeTableColumn) } is called.
     * This method will work  on any {@link TreeTableColumn} instance, regardless of 
     * its generic type. However, to enable this, a {@link StringConverter} must 
     * be provided that will convert the given String (from what the user typed 
     * in) into an instance of type T. This item will then be passed along to the 
     * {@link TreeTableColumn#onEditCommitProperty()} callback.
     * 
     * @param converter A {@link StringConverter} that can convert the given String 
     *      (from what the user typed in) into an instance of type T.
     * @return A {@link Callback} that can be inserted into the 
     *      {@link TreeTableColumn#cellFactoryProperty() cell factory property} of a 
     *      TreeTableColumn, that enables textual editing of the content.
     */
    public static <S,T> Callback<TreeTableColumn<S,T>, TreeTableCell<S,T>> forTreeTableColumn(
            final StringConverter<T> converter) {
        return list -> new TextFieldTreeTableCell<S,T>(converter);
    }
    
    
    /***************************************************************************
     *                                                                         *
     * Fields                                                                  *
     *                                                                         *
     **************************************************************************/    
    
    private TextField textField;
    
    
    
    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a default TextFieldTreeTableCell with a null converter. Without a 
     * {@link StringConverter} specified, this cell will not be able to accept
     * input from the TextField (as it will not know how to convert this back
     * to the domain object). It is therefore strongly encouraged to not use
     * this constructor unless you intend to set the converter separately.
     */
    public TextFieldTreeTableCell() { 
        this(null);
    } 
    
    /**
     * Creates a TextFieldTreeTableCell that provides a {@link TextField} when put 
     * into editing mode that allows editing of the cell content. This method 
     * will work on any TreeTableColumn instance, regardless of its generic type. 
     * However, to enable this, a {@link StringConverter} must be provided that 
     * will convert the given String (from what the user typed in) into an 
     * instance of type T. This item will then be passed along to the 
     * {@link TreeTableColumn#onEditCommitProperty()} callback.
     * 
     * @param converter A {@link StringConverter converter} that can convert 
     *      the given String (from what the user typed in) into an instance of 
     *      type T.
     */
    public TextFieldTreeTableCell(StringConverter<T> converter) {
        this.getStyleClass().add("text-field-tree-table-cell");
        setConverter(converter);
    }
        
    
    
    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/
    
    // --- converter
    private ObjectProperty<StringConverter<T>> converter = 
            new SimpleObjectProperty<StringConverter<T>>(this, "converter");

    /**
     * The {@link StringConverter} property.
     */
    public final ObjectProperty<StringConverter<T>> converterProperty() { 
        return converter; 
    }
    
    /** 
     * Sets the {@link StringConverter} to be used in this cell.
     */
    public final void setConverter(StringConverter<T> value) { 
        converterProperty().set(value); 
    }
    
    /**
     * Returns the {@link StringConverter} used in this cell.
     */
    public final StringConverter<T> getConverter() { 
        return converterProperty().get(); 
    }  
    
    
    
    /***************************************************************************
     *                                                                         *
     * Public API                                                              *
     *                                                                         *
     **************************************************************************/
    
    /** {@inheritDoc} */
    @Override public void startEdit() {
        if (! isEditable() 
                || ! getTreeTableView().isEditable() 
                || ! getTableColumn().isEditable()) {
            return;
        }
        super.startEdit();

        if (isEditing()) {
            if (textField == null) {
                textField = CellUtils.createTextField(this, getConverter());
            }

            CellUtils.startEdit(this, getConverter(), null, null, textField);
        }
    }

    /** {@inheritDoc} */
    @Override public void cancelEdit() {
        super.cancelEdit();
        CellUtils.cancelEdit(this, getConverter(), null);
    }
    
    /** {@inheritDoc} */
    @Override public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        CellUtils.updateItem(this, getConverter(), null, null, textField);
    }
}
