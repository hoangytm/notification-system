package com.hoangyth.service;

public class ElasticServiceImpl implements ElasticService{
    @Override
    public void index() {
        String jsonObject = "{\"age\":10,\"dateOfBirth\":1471466076564,"
                +"\"fullName\":\"John Doe\"}";
        IndexRequest request = new IndexRequest("people");
        request.source(jsonObject, XContentType.JSON);

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        String index = response.getIndex();
        long version = response.getVersion();

        assertEquals(Result.CREATED, response.getResult());
        assertEquals(1, version);
        assertEquals("people", index);
    }

    @Override
    public void query() {

    }

    @Override
    public void retreive() {

    }

    @Override
    public void delete() {

    }
}
