CREATE DEFINER=`root`@`localhost` TRIGGER updateParticipantes AFTER UPDATE ON programa_semanal FOR EACH ROW
BEGIN
    IF OLD.presidente IS NULL THEN
        IF NEW.presidente IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.presidente, OLD.semana, 'PRESI');
        END IF;
    ELSE
	    IF NEW.presidente IS NOT NULL THEN
		    UPDATE participacao SET codigo_publicador = NEW.presidente 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'PRESI';
        END IF;
    END IF;
    
    IF OLD.oracao_inicial IS NULL THEN
        IF NEW.oracao_inicial IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.oracao_inicial, OLD.semana, 'ORINI');
        END IF;
    ELSE
        IF NEW.oracao_inicial IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.oracao_inicial 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'ORINI';
        END IF;
    END IF;
    
    IF OLD.oracao_final IS NULL THEN
        IF NEW.oracao_final IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.oracao_final, OLD.semana, 'ORFIN');
        END IF;
    ELSE
        IF NEW.oracao_final IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.oracao_final 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'ORFIN';
        END IF;
    END IF;
    
    IF OLD.tesouros_discurso_orador IS NULL THEN
        IF NEW.tesouros_discurso_orador IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.tesouros_discurso_orador, OLD.semana, 'TEDOR');
        END IF;
    ELSE
        IF NEW.tesouros_discurso_orador IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.tesouros_discurso_orador 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'TEDOR';
        END IF;
    END IF;
    
    IF OLD.tesouros_joias_orador IS NULL THEN
        IF NEW.tesouros_joias_orador IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.tesouros_joias_orador, OLD.semana, 'TEJOR');
        END IF;
    ELSE
        IF NEW.tesouros_joias_orador IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.tesouros_joias_orador 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'TEJOR';
        END IF;
    END IF;
    
    IF OLD.tesouros_leitura_orador IS NULL THEN
        IF NEW.tesouros_leitura_orador IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao, licao) VALUES (NEW.tesouros_leitura_orador, OLD.semana, 'TELOR', NEW.tesouros_leitura_licao);
        END IF;
    ELSE
        IF NEW.tesouros_leitura_orador IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.tesouros_leitura_orador, licao = NEW.tesouros_leitura_licao
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'TELOR';
        END IF;
    END IF;
    
    IF OLD.ministerio_um_discurso_orador IS NULL THEN
        IF NEW.ministerio_um_discurso_orador IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.ministerio_um_discurso_orador, OLD.semana, 'MUDOR');
        END IF;
    ELSE
        IF NEW.ministerio_um_discurso_orador IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.ministerio_um_discurso_orador 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'MUDOR';
        END IF;
    END IF;
    
    IF OLD.ministerio_tres_visita_orador IS NULL THEN
        IF NEW.ministerio_tres_visita_orador IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao, licao) VALUES (NEW.ministerio_tres_visita_orador, OLD.semana, 'MTVOR', NEW.ministerio_tres_visita_licao);
        END IF;
    ELSE
        IF NEW.ministerio_tres_visita_orador IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.ministerio_tres_visita_orador, licao = NEW.ministerio_tres_visita_licao 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'MTVOR';
        END IF;
    END IF;
    
    IF OLD.ministerio_tres_visita_aux IS NULL THEN
        IF NEW.ministerio_tres_visita_aux IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.ministerio_tres_visita_aux, OLD.semana, 'MTVAU');
        END IF;
    ELSE
        IF NEW.ministerio_tres_visita_aux IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.ministerio_tres_visita_aux 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'MTVAU';
        END IF;
    END IF;
    
    IF OLD.ministerio_tres_revisita_orador IS NULL THEN
        IF NEW.ministerio_tres_revisita_orador IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao, licao) VALUES (NEW.ministerio_tres_revisita_orador, OLD.semana, 'MTROR', NEW.ministerio_tres_revisita_licao);
        END IF;
    ELSE
        IF NEW.ministerio_tres_revisita_orador IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.ministerio_tres_revisita_orador, licao = NEW.ministerio_tres_revisita_licao
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'MTROR';
        END IF;
    END IF;
    
    IF OLD.ministerio_tres_revisita_aux IS NULL THEN
        IF NEW.ministerio_tres_revisita_aux IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.ministerio_tres_revisita_aux, OLD.semana, 'MTRAU');
        END IF;
    ELSE
        IF NEW.ministerio_tres_revisita_aux IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.ministerio_tres_revisita_aux 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'MTRAU';
        END IF;
    END IF;
    
    IF OLD.ministerio_tres_estudo_orador IS NULL THEN
        IF NEW.ministerio_tres_estudo_orador IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao, licao) VALUES (NEW.ministerio_tres_estudo_orador, OLD.semana, 'MTEOR', NEW.ministerio_tres_estudo_licao);
        END IF;
    ELSE
        IF NEW.ministerio_tres_estudo_orador IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.ministerio_tres_estudo_orador, licao = NEW.ministerio_tres_estudo_licao 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'MTEOR';
        END IF;
    END IF;
    
    IF OLD.ministerio_tres_estudo_aux IS NULL THEN
        IF NEW.ministerio_tres_estudo_aux IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.ministerio_tres_estudo_aux, OLD.semana, 'MTEAU');
        END IF;
    ELSE
        IF NEW.ministerio_tres_estudo_aux IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.ministerio_tres_estudo_aux 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'MTEAU';
        END IF;
    END IF;
    
    IF OLD.ministerio_tres_discurso_orador IS NULL THEN
        IF NEW.ministerio_tres_discurso_orador IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao, licao) VALUES (NEW.ministerio_tres_discurso_orador, OLD.semana, 'MTDOR', NEW.ministerio_tres_discurso_licao);
        END IF;
    ELSE
        IF NEW.ministerio_tres_discurso_orador IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.ministerio_tres_discurso_orador, licao = NEW.ministerio_tres_discurso_licao 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'MTDOR';
        END IF;
    END IF;
    
    IF OLD.vida_parte1_orador IS NULL THEN
        IF NEW.vida_parte1_orador IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.vida_parte1_orador, OLD.semana, 'VPUOR');
        END IF;
    ELSE
        IF NEW.vida_parte1_orador IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.vida_parte1_orador 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'VPUOR';
        END IF;
    END IF;
    
    IF OLD.vida_parte2_orador IS NULL THEN
        IF NEW.vida_parte2_orador IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.vida_parte2_orador, OLD.semana, 'VPDOR');
        END IF;
    ELSE
        IF NEW.vida_parte2_orador IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.vida_parte2_orador 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'VPDOR';
        END IF;
    END IF;
    
    IF OLD.estudo_dirigente IS NULL THEN
        IF NEW.estudo_dirigente IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.estudo_dirigente, OLD.semana, 'VEDIR');
        END IF;
    ELSE
        IF NEW.estudo_dirigente IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.estudo_dirigente 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'VEDIR';
        END IF;
    END IF;
    
    IF OLD.estudo_leitor IS NULL THEN
        IF NEW.estudo_leitor IS NOT NULL THEN
            INSERT INTO participacao (codigo_publicador, semana, tipo_participacao) VALUES (NEW.estudo_leitor, OLD.semana, 'VELEI');
        END IF;
    ELSE
        IF NEW.estudo_leitor IS NOT NULL THEN
            UPDATE participacao SET codigo_publicador = NEW.estudo_leitor 
            WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'VELEI';
        END IF;
    END IF;
END