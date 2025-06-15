-- Tabela: cities
CREATE TABLE public.cities (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    state VARCHAR,
    uf VARCHAR
);

-- Tabela: companies
CREATE TABLE public.companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    cnpj VARCHAR NOT NULL,
    phone VARCHAR,
    email VARCHAR,
    city_id INTEGER NOT NULL
);

-- Tabela: users
CREATE TABLE public.users (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    cpf VARCHAR NOT NULL,
    phone VARCHAR,
    email VARCHAR,
    password VARCHAR NOT NULL,
    is_young BOOLEAN NOT NULL,
    company_id INTEGER NOT NULL,
    city_id INTEGER NOT NULL,
    nickname VARCHAR,
    birthdate VARCHAR
);

-- Tabela: psychologists
CREATE TABLE public.psychologists (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    cpf VARCHAR NOT NULL,
    crp VARCHAR NOT NULL,
    phone VARCHAR,
    email VARCHAR,
    password VARCHAR NOT NULL,
    profile_photo TEXT,
    specialty VARCHAR,
    city_id INTEGER NOT NULL
);

-- Tabela: nicknames
CREATE TABLE public.nicknames (
    id SERIAL PRIMARY KEY,
    nickname VARCHAR NOT NULL
);

-- Tabela: rants
CREATE TABLE public.rants (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    user_id INTEGER NOT NULL,
    report_count INTEGER DEFAULT 0,
    description TEXT NOT NULL
);

-- Tabela: reactions
CREATE TABLE public.reactions (
    id SERIAL PRIMARY KEY,
    description VARCHAR NOT NULL
);

-- Tabela: rants_reactions
CREATE TABLE public.rants_reactions (
    id SERIAL PRIMARY KEY,
    rant_id INTEGER NOT NULL,
    reaction_id INTEGER NOT NULL
);



INSERT INTO public.cities (name, state, uf) VALUES
('São Paulo', 'São Paulo', 'SP'),
('Rio de Janeiro', 'Rio de Janeiro', 'RJ'),
('Belo Horizonte', 'Minas Gerais', 'MG'),
('Curitiba', 'Paraná', 'PR'),
('Porto Alegre', 'Rio Grande do Sul', 'RS'),
('Salvador', 'Bahia', 'BA'),
('Fortaleza', 'Ceará', 'CE'),
('Recife', 'Pernambuco', 'PE'),
('Manaus', 'Amazonas', 'AM'),
('Brasília', 'Distrito Federal', 'DF');


INSERT INTO public.reactions (description) VALUES
('Você não está sozinho(a). Estamos aqui para você.'),
('É corajoso da sua parte compartilhar isso.'),
('Lembre-se: tudo passa, mesmo os dias difíceis.'),
('Você é mais forte do que imagina.'),
('Estamos com você nessa caminhada.'),
('Se precisar, não hesite em pedir ajuda.'),
('Sua dor é válida e merece atenção.'),
('Um passo de cada vez. Você consegue.'),
('Não tenha vergonha de sentir. Sentir é humano.'),
('Você importa. Muito.');

INSERT INTO public.companies (name, cnpj, phone, email, city_id) VALUES
('BemEstar Tech', '12.345.678/0001-90', '(11) 99999-0001', 'contato@bemestartec.com', 1),
('Mente Aberta S/A', '98.765.432/0001-10', '(21) 98888-0002', 'suporte@menteaberta.com', 2),
('Vida Plena LTDA', '45.678.901/0001-55', '(31) 97777-0003', 'faleconosco@vidaplena.com', 3),
('Saúde Mental Brasil', '23.456.789/0001-77', '(41) 96666-0004', 'contato@saudementalbr.com', 4),
('CuidarTech', '34.567.890/0001-22', '(51) 95555-0005', 'hello@cuidartech.com', 5);


INSERT INTO public.nicknames (nickname) VALUES
('SolLunar'),
('CoraçãoAberto'),
('AnônimoEsperançoso'),
('PoeiraEstelar'),
('SilêncioFalante'),
('PensadorLivre'),
('OlharDoVento'),
('LuzNaEscuridão'),
('EcosDaAlma'),
('AlmaViajante');