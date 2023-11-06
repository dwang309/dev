package com.dw.batch.common.writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

@Slf4j
public class NoOpsItemWriter implements ItemWriter {
    @Override
    public void write(Chunk chunk) throws Exception {
        chunk.getItems().forEach(c -> log.info(c.toString()));
    }
}
