package io.github.maximilianoalves.payloads;

import com.google.gson.Gson;
import io.github.maximilianoalves.payloads.model.produtos.ProdutosModel;
import io.github.maximilianoalves.utils.Utils;

public class ProdutosPayload {

    public static String toJson(){
        ProdutosModel produtos = new ProdutosModel(Utils.faker.commerce().productName(), 50, Utils.faker.lorem().sentence(5), 3);
        return new Gson().toJson(produtos);
    }

}
