
DELIMITER $$
DROP TRIGGER IF EXISTS updateParticipantes;
$$
DELIMITER //
CREATE TRIGGER updateParticipantes AFTER UPDATE ON programa_semanal
/*
A TABELA PROGRAMA_SEMANAL PODE SER ATUALIZADA DE DUAS FORMAS:
1. AO ALTERAR A APOSTILA
   1.1. NADA DEVE SER FEITO
2. AO DESIGNAR PUBLICADORES
   2.1. SE A ALTERAÇÃO FOR PARA MUDAR O DESIGNADO ATUAL:
        COLUNA CODIGO_PUBLICADOR DEVERÁ TER O VALOR ATUALIZADO, PARA AQUELE TIPO DE PARTICIPAÇÃO E AQUELA DATA
   2.2. SE A ALTERAÇÃO FOR PARA DESIGNAR UM PUBLICADOR PELA PRIMEIRA VEZ:
        NOVO REGISTRO DEVE SER INSERIDO NA TABELA PARTICIPACAO
*/
    FOR EACH ROW
    BEGIN
        -- SE FOREM IGUAIS, ESTÁ ALTERANDO A APOSTILA, PORTANTO NADA DEVE SER FEITO
        -- SE FOREM DIFERENTES, OU ESTÁ DESIGNANDO PELA PRIMEIRA VEZ OU ESTÁ ALTERANDO O ATUAL
        IF OLD.PRESIDENTE <> NEW.PRESIDENTE THEN
            IF OLD.presidente IS NULL THEN
                -- 2.2 - DESIGNANDO PELA PRIMEIRA VEZ
                INSERT INTO participacao (codigo_publicador, data, participacao) VALUES (NEW.presidente, NEW.semana, 'PRESI');
            ELSE
                -- 2.1 - ALTERANDO PRESIDENTE DAQUELA SEMANA
                UPDATE participacao SET codigo_publicador = NEW.presidente 
                WHERE participacao.data = new.semana
                AND participacao.participacao = "PRESI";
            END IF;
        END IF;
        
        -- SE FOREM IGUAIS, ESTÁ ALTERANDO A APOSTILA, PORTANTO NADA DEVE SER FEITO
        -- SE FOREM DIFERENTES, OU ESTÁ DESIGNANDO PELA PRIMEIRA VEZ OU ESTÁ ALTERANDO O ATUAL
        IF OLD.oracao_inicial <> NEW.oracao_inicial THEN
            IF OLD.oracao_inicial IS NULL THEN
                -- DESIGNANDO PELA PRIMEIRA VEZ
                INSERT INTO participacao (codigo_publicador, data, participacao) VALUES (NEW.oracao_inicial, NEW.semana, 'ORINI');
            ELSE
                -- ALTERANDO DESIGNADO DAQUELA SEMANA
                UPDATE participacao SET codigo_publicador = NEW.oracao_inicial
                WHERE participacao.data = new.semana
                AND participacao.participacao = "ORINI";
            END IF;
        END IF;
        
    END