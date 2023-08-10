package org.nasuda.shopping.model;


import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(
    includeClasses = {Cart.class, CartItem.class, Product.class},
    schemaPackageName = "example"
    )
public interface CartSchema extends GeneratedSchema  {
    
}
