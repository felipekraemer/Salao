
DELIMITER $$
DROP TRIGGER IF EXISTS updateParticipantes;
$$
DELIMITER //
CREATE TRIGGER updateParticipantes AFTER UPDATE ON programa_semanal FOR EACH ROW
BEGIN
        IF OLD.presidente IS NULL THEN
            IF NEW.presidente IS NOT NULL THEN
            
				INSERT INTO participacao (codigo_pessoa, semana, tipo_participacao) VALUES (NEW.presidente, OLD.semana, 'P');
                
		   END IF;
		ELSE             
		    IF NEW.presidente IS NOT NULL THEN
            
				UPDATE participacao SET codigo_pessoa = NEW.presidente WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'P';
                
            END IF;
        END IF;
        
        
        IF OLD.orador IS NULL THEN
            IF NEW.orador IS NOT NULL THEN
            
				INSERT INTO participacao (codigo_pessoa, semana, tipo_participacao) VALUES (NEW.orador, OLD.semana, 'O');
                
		   END IF;
		ELSE             
		    IF NEW.orador IS NOT NULL THEN
				
                UPDATE participacao SET codigo_pessoa = NEW.orador WHERE participacao.semana = OLD.semana AND participacao.tipo_participacao = 'O';
                
            END IF;
        END IF;
END