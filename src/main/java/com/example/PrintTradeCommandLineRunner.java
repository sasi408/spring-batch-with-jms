package com.example;

import com.example.model.Trade;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PrintTradeCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        log.info("marshalling Trade");

        Trade trade = Trade.builder()
                .quantity(100)
                .action(Trade.Action.BUY)
                .stock("AAPL")
                .build();

        XStream xStream = new XStream();
        xStream.alias("trade", Trade.class);

        log.info(xStream.toXML(trade));
    }
}
